#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

/* Team Members: 
Qingyun Zhang 2095754
Sicong Liu 2089129
Ying Lu 2093558 */

typedef struct {
    int x, y;
} Point;

int max(int a, int b) {
    return (a > b) ? a : b;
}

int min(int a, int b) {
    return (a < b) ? a : b;
}

int isDiagonal(Point p1, Point p2) {
    return abs(p1.x - p2.x) == abs(p1.y - p2.y);
}

int main() {
    FILE *inputFile, *outputFile;
    Point *points = NULL;
    int count = 0, x, y, minX = INT_MAX, maxX = INT_MIN, minY = INT_MAX, maxY = INT_MIN;
    int error = 0;
    char line[20];

    inputFile = fopen("input.txt", "r");
    if (inputFile == NULL) {
        perror("Error opening input file");
        return 1;
    }

    // Reading points from file
    while (fgets(line, sizeof(line), inputFile)) {
        if (line[0] == 'E') {
            break;
        }
        if (sscanf(line, "%d,%d", &x, &y) != 2) {
            error = 1; // Error in input format
            break;
        }
        Point p = {x, y};
        points = realloc(points, sizeof(Point) * (++count));
        if (!points) {
            error = 1;
            break;
        }
        points[count - 1] = p;

        // Update min and max coordinates
        minX = min(minX, x);
        maxX = max(maxX, x);
        minY = min(minY, y);
        maxY = max(maxY, y);
    }
    fclose(inputFile);

    if (error || count < 2 || points[0].x != points[count - 1].x || points[0].y != points[count - 1].y) {
        outputFile = fopen("output.txt", "w");
        if (outputFile != NULL) {
            fprintf(outputFile, "Error");
            fclose(outputFile);
        }
        free(points);
        return 1;
    }

    int width = maxX - minX + 1;
    int height = maxY - minY + 1;

    // Creating a dynamic 2D array for the drawing
    char **drawing = malloc(height * sizeof(char *));
    if (!drawing) {
        free(points);
        return 1;
    }
    for (int i = 0; i < height; i++) {
        drawing[i] = malloc(width * sizeof(char));
        if (!drawing[i]) {
            for (int j = 0; j < i; j++) {
                free(drawing[j]);
            }
            free(drawing);
            free(points);
            return 1;
        }
        memset(drawing[i], ' ', width * sizeof(char));
    }

    // Drawing lines between points
    for (int i = 0; i < count - 1; i++) {
        Point p1 = points[i], p2 = points[i + 1];
        if (p1.x == p2.x) {
            for (int y = min(p1.y, p2.y); y <= max(p1.y, p2.y); y++) {
                drawing[height - 1 - (y - minY)][p1.x - minX] = '*'; // Inverting y-axis
            }
        } else if (p1.y == p2.y) {
            for (int x = min(p1.x, p2.x); x <= max(p1.x, p2.x); x++) {
                drawing[height - 1 - (p1.y - minY)][x - minX] = '*'; // Inverting y-axis
            }
        } else if (isDiagonal(p1, p2)) {
            int dx = (p2.x - p1.x) > 0 ? 1 : -1;
            int dy = (p2.y - p1.y) > 0 ? 1 : -1;
            for (int x = p1.x, y = p1.y; x != p2.x + dx; x += dx, y += dy) {
                drawing[height - 1 - (y - minY)][x - minX] = '*'; // Inverting y-axis
            }
        }
    }

    // Writing the drawing to an output file
    outputFile = fopen("output.txt", "w");
    if (outputFile == NULL) {
        perror("Error opening output file");
        for (int i = 0; i < height; i++) {
            free(drawing[i]);
        }
        free(drawing);
        free(points);
        return 1;
    }
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            fprintf(outputFile, "%c", drawing[i][j]);
        }
        fprintf(outputFile, "\n");
    }
    fclose(outputFile);

    // Freeing allocated memory
    for (int i = 0; i < height; i++) {
        free(drawing[i]);
    }
    free(drawing);
    free(points);

    return 0;
}
