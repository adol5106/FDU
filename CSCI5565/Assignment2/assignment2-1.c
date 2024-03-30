#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x, y;
} Point;

void drawShape(const char* inputFile, const char* outputFile);
void writeErrorToFile(const char* filename);

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf("Usage: <executable> input_file output_file\n");
        return EXIT_FAILURE;
    }

    drawShape(argv[1], argv[2]);
    return EXIT_SUCCESS;
}

void drawShape(const char* inputFile, const char* outputFile) {
    FILE *fp = fopen(inputFile, "r");
    if (!fp) {
        writeErrorToFile(outputFile);
        return;
    }

    int x, y, minX = 0, minY = 0, maxX = 0, maxY = 0;
    Point points[100]; // Assuming a simple shape will not exceed 100 points.
    int count = 0;

    while (fscanf(fp, "%d,%d\n", &x, &y) == 2) {
        if (x < minX) minX = x;
        if (y < minY) minY = y;
        if (x > maxX) maxX = x;
        if (y > maxY) maxY = y;
        points[count++] = (Point){x, y};
    }

    fclose(fp);

    if (count == 0) {
        writeErrorToFile(outputFile);
        return;
    }

    // Determine size of the canvas
    int width = maxX - minX + 1;
    int height = maxY - minY + 1;

    char **canvas = (char**) malloc(height * sizeof(char*));
    if (!canvas) {
        writeErrorToFile(outputFile);
        return;
    }

    for (int i = 0; i < height; ++i) {
        canvas[i] = (char*) malloc(width * sizeof(char));
        if (!canvas[i]) {
            while (i--) free(canvas[i]); // Free allocated memory on error
            free(canvas);
            writeErrorToFile(outputFile);
            return;
        }
        for (int j = 0; j < width; ++j) {
            canvas[i][j] = ' '; // Initialize canvas with spaces
        }
    }

    // Draw shape (simplified logic; needs implementation based on the shape)

    // Write to output file
    fp = fopen(outputFile, "w");
    if (!fp) {
        for (int i = 0; i < height; ++i) free(canvas[i]);
        free(canvas);
        writeErrorToFile(outputFile);
        return;
    }

    for (int i = 0; i < height; ++i) {
        for (int j = 0; j < width; ++j) {
            fputc(canvas[i][j] == ' ' ? ' ' : '*', fp);
        }
        fputc('\n', fp);
    }

    fclose(fp);
    for (int i = 0; i < height; ++i) free(canvas[i]);
    free(canvas);
}

void writeErrorToFile(const char* filename) {
    FILE *fp = fopen(filename, "w");
    if (fp) {
        fprintf(fp, "Error");
        fclose(fp);
    }
}

