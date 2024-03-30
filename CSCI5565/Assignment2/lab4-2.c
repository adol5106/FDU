#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int x, y;
} Point;

void plotLineLow(char **canvas, int x0, int y0, int x1, int y1) {
    int dx = x1 - x0;
    int dy = y1 - y0;
    int yi = 1;
    if (dy < 0) {
        yi = -1;
        dy = -dy;
    }
    int D = (2 * dy) - dx;
    int y = y0;

    for (int x = x0; x <= x1; x++) {
        if (x >= 0 && x < 100 && y >= 0 && y < 100) { // Ensure within canvas bounds
            canvas[y][x] = '*';
        }
        if (D > 0) {
            y += yi;
            D += (2 * (dy - dx));
        } else {
            D += 2 * dy;
        }
    }
}

void plotLineHigh(char **canvas, int x0, int y0, int x1, int y1) {
    int dx = x1 - x0;
    int dy = y1 - y0;
    int xi = 1;
    if (dx < 0) {
        xi = -1;
        dx = -dx;
    }
    int D = (2 * dx) - dy;
    int x = x0;

    for (int y = y0; y <= y1; y++) {
        if (x >= 0 && x < 100 && y >= 0 && y < 100) { // Ensure within canvas bounds
            canvas[y][x] = '*';
        }
        if (D > 0) {
            x += xi;
            D += (2 * (dx - dy));
        } else {
            D += 2 * dx;
        }
    }
}

void plotLine(char **canvas, Point a, Point b) {
    if (abs(b.y - a.y) < abs(b.x - a.x)) {
        if (a.x > b.x) plotLineLow(canvas, b.x, b.y, a.x, a.y);
        else plotLineLow(canvas, a.x, a.y, b.x, b.y);
    } else {
        if (a.y > b.y) plotLineHigh(canvas, b.x, b.y, a.x, a.y);
        else plotLineHigh(canvas, a.x, a.y, b.x, b.y);
    }
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf("Usage: %s <input_file> <output_file>\n", argv[0]);
        return EXIT_FAILURE;
    }

    FILE *input = fopen(argv[1], "r");
    if (!input) {
        perror("Error opening input file");
        return EXIT_FAILURE;
    }

    Point points[100]; // Adjust size as necessary
    int count = 0;
    while (fscanf(input, "%d,%d\n", &points[count].x, &points[count].y) == 2) {
        count++;
    }
    fclose(input);

    char *canvas[100]; // Canvas size of 100x100, adjust as necessary
    for (int i = 0; i < 100; i++) {
        canvas[i] = (char *)malloc(100 * sizeof(char));
        memset(canvas[i], ' ', 100);
    }

    for (int i = 0; i < count - 1; i++) {
        plotLine(canvas, points[i], points[i + 1]);
    }

    FILE *output = fopen(argv[2], "w");
    if (!output) {
        perror("Error opening output file");
        return EXIT_FAILURE;
    }

    for (int y = 0; y < 100; y++) {
        for (int x = 0; x < 100; x++) {
            fputc(canvas[y][x], output);
        }
        fputc('\n', output);
    }

    fclose(output);
    for (int i = 0; i < 100; i++) free(canvas[i]);

    return 0;
}
