#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x, y;
} Point;

void readCoordinates(const char* filename, Point** points, int* count) {
    FILE* file = fopen(filename, "r");
    if (!file) {
        perror("Error opening file");
        exit(EXIT_FAILURE);
    }

    Point temp;
    *count = 0;
    while (fscanf(file, "%d,%d\n", &temp.x, &temp.y) == 2) {
        *points = realloc(*points, (*count + 1) * sizeof(Point));
        (*points)[*count] = temp;
        (*count)++;
    }

    fclose(file);
}

void drawShape(Point* points, int count, char** canvas, int maxX, int maxY) {
    // Assuming canvas is initialized with spaces and has dimensions maxX x maxY
    for (int i = 0; i < count - 1; i++) {
        int x1 = points[i].x, y1 = points[i].y;
        int x2 = points[i + 1].x, y2 = points[i + 1].y;
        canvas[y1][x1] = '*';
        canvas[y2][x2] = '*'; // Simple placeholder for drawing logic
    }
}

void fillShape(char** canvas, int maxX, int maxY) {
    int inside = 0;
    for (int y = 0; y < maxY; y++) {
        inside = 0; // Reset for each line
        for (int x = 0; x < maxX; x++) {
            if (canvas[y][x] == '*') {
                inside = !inside; // Toggle inside status on edge
                continue;
            }
            if (inside) {
                canvas[y][x] = '*'; // Fill if inside
            }
        }
    }
}


void writeOutput(const char* filename, char** canvas, int maxX, int maxY) {
    FILE* file = fopen(filename, "w");
    if (!file) {
        perror("Error writing to file");
        exit(EXIT_FAILURE);
    }

    for (int y = 0; y < maxY; y++) {
        for (int x = 0; x < maxX; x++) {
            fputc(canvas[y][x], file);
        }
        fputc('\n', file);
    }

    fclose(file);
}

int main(int argc, char* argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Usage: %s <input_file> <output_file>\n", argv[0]);
        return EXIT_FAILURE;
    }

    Point* points = NULL;
    int count = 0;
    readCoordinates(argv[1], &points, &count);

    // Assuming canvas size
    int maxX = 100, maxY = 100;
    char** canvas = malloc(maxY * sizeof(char*));
    for (int i = 0; i < maxY; i++) {
        canvas[i] = malloc(maxX * sizeof(char));
        for (int j = 0; j < maxX; j++) {
            canvas[i][j] = ' '; // Initialize with spaces
        }
    }

    drawShape(points, count, canvas, maxX, maxY);
    fillShape(canvas, maxX, maxY); // Uncomment when fill logic is implemented
    writeOutput(argv[2], canvas, maxX, maxY);

    // Cleanup
    for (int i = 0; i < maxY; i++) free(canvas[i]);
    free(canvas);
    free(points);

    return EXIT_SUCCESS;
}

