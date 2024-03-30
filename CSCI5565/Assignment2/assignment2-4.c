#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x, y;
} Point;


void readCoordinates(const char* filename, Point** points, int* count) {
    FILE* file = fopen(filename, "r");
    if (!file) {
        perror("Failed to open input file");
        exit(EXIT_FAILURE);
    }

    *count = 0;
    Point p;
    while (fscanf(file, "%d,%d\n", &p.x, &p.y) == 2) {
        if (p.x == 'E' - '0') break; // Assuming 'E' ends data
        (*count)++;
        *points = realloc(*points, (*count) * sizeof(Point));
        (*points)[*count - 1] = p;
    }
    fclose(file);
}

void drawShape(Point* points, int count, char** canvas, int maxX, int maxY) {
    for (int i = 0; i < count - 1; i++) {
        int x = points[i].x;
        int y = points[i].y;
        int dx = points[i + 1].x - x;
        int dy = points[i + 1].y - y;
        int maxD = abs(dx) > abs(dy) ? abs(dx) : abs(dy);
        for (int j = 0; j <= maxD; j++) {
            int plotX = x + j * dx / maxD;
            int plotY = y + j * dy / maxD;
            if (plotX >= 0 && plotX < maxX && plotY >= 0 && plotY < maxY) {
                canvas[plotY][plotX] = '*';
            }
        }
    }
}



void fillShape(char** canvas, int maxX, int maxY) {
    for (int y = 0; y < maxY; y++) {
        int fill = 0;
        for (int x = 0; x < maxX; x++) {
            if (canvas[y][x] == '*') {
                if (x + 1 < maxX && canvas[y][x + 1] == ' ') {
                    fill = !fill;
                }
            } else if (fill) {
                canvas[y][x] = '*';
            }
        }
    }
}



void writeOutput(const char* filename, char** canvas, int maxX, int maxY) {
    FILE* file = fopen(filename, "w");
    if (!file) {
        perror("Failed to open output file");
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
        printf("Usage: %s <input_file> <output_file>\n", argv[0]);
        return EXIT_FAILURE;
    }

    Point* points = NULL;
    int count = 0;
    readCoordinates(argv[1], &points, &count);

    // Assume max canvas size; dynamically calculate based on points for optimization
    int maxX = 100, maxY = 100;
    char** canvas = (char**)malloc(maxY * sizeof(char*));
    for (int i = 0; i < maxY; i++) {
        canvas[i] = (char*)malloc(maxX * sizeof(char));
        for (int j = 0; j < maxX; j++) {
            canvas[i][j] = ' '; // Initialize with spaces
        }
    }

    drawShape(points, count, canvas, maxX, maxY);
    //fillShape(canvas, maxX, maxY);
    writeOutput(argv[2], canvas, maxX, maxY);

    // Cleanup
    for (int i = 0; i < maxY; i++) {
        free(canvas[i]);
    }
    free(canvas);
    free(points);

    return 0;
}
