#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x, y;
} Point;

// Function to read coordinates from the file
int readCoordinates(const char* filename, Point** points) {
    FILE* file = fopen(filename, "r");
    if (!file) {
        printf("Error opening input file.\n");
        return -1;
    }

    int capacity = 10;
    *points = (Point*)malloc(capacity * sizeof(Point));
    int count = 0, x, y;
    while (fscanf(file, "%d,%d\n", &x, &y) == 2) {
        if (x == 0 && y == 0 && count > 0) break; // End if returning to origin or 'E' encountered
        if (count >= capacity) {
            capacity *= 2;
            *points = (Point*)realloc(*points, capacity * sizeof(Point));
        }
        (*points)[count++] = (Point){x, y};
    }
    fclose(file);
    return count;
}

void drawLine(char** canvas, Point start, Point end) {
    int dx = end.x - start.x, dy = end.y - start.y;
    
    int steps = abs(dx) > abs(dy) ? abs(dx) : abs(dy);

    float xIncrement = dx / (float) steps;
    float yIncrement = dy / (float) steps;

    float x = start.x;
    float y = start.y;
    for (int i = 0; i <= steps; i++) {
        canvas[(int)y][(int)x] = '*';
        x += xIncrement;
        y += yIncrement;
    }
}

void fillShape(char** canvas, int maxX, int maxY) {
    // Simplified fill algorithm: Toggle filling when encountering a line
    for (int y = 0; y < maxY; y++) {
        int fill = 0;
        for (int x = 0; x < maxX; x++) {
            if (canvas[y][x] == '*') {
                fill = !fill;
                continue;
            }
            if (fill) canvas[y][x] = '*';
        }
    }
}

void drawShape(Point* points, int count, char** canvas, int maxX, int maxY) {
    for (int i = 0; i < count - 1; i++) {
        drawLine(canvas, points[i], points[i + 1]);
    }

    fillShape(canvas, maxX, maxY);
}

// Function to write the canvas to the output file
void writeCanvas(const char* filename, char** canvas, int width, int height) {
    FILE* file = fopen(filename, "w");
    if (!file) {
        printf("Error opening output file.\n");
        return;
    }

    for (int i = 0; i < height; ++i) {
        for (int j = 0; j < width; ++j) {
            fputc(canvas[i][j], file);
        }
        fputc('\n', file);
    }
    fclose(file);
}

int main(int argc, char* argv[]) {
    if (argc != 3) {
        printf("Usage: <executable> <input_file> <output_file>\n");
        return 1;
    }

    Point* points;
    int count = readCoordinates(argv[1], &points);
    if (count < 0) return 1;

    // Assuming the maximum size for simplicity. In practice, calculate the minimum bounding box.
    int maxX = 0, maxY = 0;
    for (int i = 0; i < count; ++i) {
        if (points[i].x > maxX) maxX = points[i].x;
        if (points[i].y > maxY) maxY = points[i].y;
    }
    maxX += 1; maxY += 1; // Adjust for 0-indexing and ensure space for the highest point/line

    char** canvas = (char**)malloc(maxY * sizeof(char*));
    for (int i = 0; i < maxY; ++i) {
        canvas[i] = (char*)malloc(maxX * sizeof(char));
        for (int j = 0; j < maxX; ++j) {
            canvas[i][j] = ' '; // Initialize with spaces
        }
    }

    drawShape(points, count, canvas, maxX, maxY);
    writeCanvas(argv[2], canvas, maxX, maxY);

    // Free memory
    for (int i = 0; i < maxY; ++i) free(canvas[i]);
    free(canvas);
    free(points);

    return 0;
}