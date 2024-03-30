#include <stdio.h>
#include <stdlib.h>

// Function to draw the shape based on the provided coordinates
void draw_shape(FILE *input, FILE *output) {
    char prev_x, prev_y, curr_x, curr_y;
    int min_x = 0, max_x = 0, min_y = 0, max_y = 0;
    
    // Read the first coordinate
    fscanf(input, "%hhd,%hhd\n", &prev_x, &prev_y);
    min_x = max_x = prev_x;
    min_y = max_y = prev_y;

    // Determine the bounding box of the shape
    while (fscanf(input, "%hhd,%hhd\n", &curr_x, &curr_y) == 2) {
        if (curr_x < min_x) min_x = curr_x;
        if (curr_x > max_x) max_x = curr_x;
        if (curr_y < min_y) min_y = curr_y;
        if (curr_y > max_y) max_y = curr_y;
    }

    // Calculate the dimensions of the shape
    int width = max_x - min_x + 1;
    int height = max_y - min_y + 1;

    // Allocate memory for the shape
    char **shape = (char **)malloc(sizeof(char *) * height);
    for (int i = 0; i < height; i++) {
        shape[i] = (char *)malloc(sizeof(char) * width);
        for (int j = 0; j < width; j++) {
            shape[i][j] = ' ';
        }
    }

    // Reset file pointer to beginning of file
    fseek(input, 0, SEEK_SET);

    // Draw the shape on the allocated memory
    while (fscanf(input, "%hhd,%hhd\n", &prev_x, &prev_y) == 2) {
        fscanf(input, "%hhd,%hhd\n", &curr_x, &curr_y);
        if (prev_x == curr_x) { // Vertical line
            int y1 = prev_y - min_y;
            int y2 = curr_y - min_y;
            for (int i = y1; i <= y2; i++) {
                shape[i][prev_x - min_x] = '*';
            }
        } else if (prev_y == curr_y) { // Horizontal line
            int x1 = prev_x - min_x;
            int x2 = curr_x - min_x;
            for (int i = x1; i <= x2; i++) {
                shape[prev_y - min_y][i] = '*';
            }
        } else { // 45 degree line (handled implicitly)
            shape[prev_y - min_y][prev_x - min_x] = '*';
        }
    }

    // Write the shape to the output file
    for (int i = 0; i < height; i++) {
        fprintf(output, "%s\n", shape[i]);
    }

    // Free allocated memory
    for (int i = 0; i < height; i++) {
        free(shape[i]);
    }
    free(shape);
}

// Main function
int main(int argc, char *argv[]) {
    // Check if correct number of command line arguments are provided
    if (argc != 3) {
        printf("Usage: %s input_file output_file\n", argv[0]);
        return 1;
    }

    // Open the input file
    FILE *input = fopen(argv[1], "r");
    if (input == NULL) {
        printf("Error opening input file.\n");
        return 1;
    }

    // Open the output file
    FILE *output = fopen(argv[2], "w");
    if (output == NULL) {
        printf("Error opening output file.\n");
        fclose(input);
        return 1;
    }

    // Draw the shape and write to the output file
    draw_shape(input, output);

    // Close files
    fclose(input);
    fclose(output);

    return 0;
}