#include <stdio.h>
#include <stdlib.h>

#define MAX_PARTICLES 100

typedef struct {
    int x;
    int y;
    int vx;
    int vy;
} Particle;

void simulate_particles(int x_dim, int y_dim, int sim_time, Particle particles[], int num_particles) {
    int t, i, j;

    for (t = 0; t < sim_time; t++) {
        // Update particle positions
        for (i = 0; i < num_particles; i++) {
            particles[i].x += particles[i].vx;
            particles[i].y += particles[i].vy;

            // Handle boundary conditions
            if (particles[i].x < 0 || particles[i].x >= x_dim) {
                particles[i].vx = -particles[i].vx;
                particles[i].x += 2 * particles[i].vx;
            }
            if (particles[i].y < 0 || particles[i].y >= y_dim) {
                particles[i].vy = -particles[i].vy;
                particles[i].y += 2 * particles[i].vy;
            }
        }

        // Check for collisions and remove collided particles
        for (i = 0; i < num_particles; i++) {
            for (j = i + 1; j < num_particles; j++) {
                if (particles[i].x == particles[j].x && particles[i].y == particles[j].y) {
                    particles[i].x = -1;
                    particles[i].y = -1;
                    particles[j].x = -1;
                    particles[j].y = -1;
                }
            }
        }
    }
}

void print_output(int x_dim, int y_dim, Particle particles[], int num_particles) {
    int i, j;

    for (i = -1; i <= y_dim; i++) {
        for (j = -1; j <= x_dim; j++) {
            if (i == -1 || i == y_dim || j == -1 || j == x_dim) {
                printf("*");
            } else {
                int particle_found = 0;
                for (int k = 0; k < num_particles; k++) {
                    if (particles[k].x == j && particles[k].y == i) {
                        printf("+");
                        particle_found = 1;
                        break;
                    }
                }
                if (!particle_found) {
                    printf(" ");
                }
            }
        }
        printf("\n");
    }
}

int main() {
    int x_dim, y_dim, sim_time, num_particles;
    Particle particles[MAX_PARTICLES];

    // Read input from file
    FILE *input_file = fopen("input.txt", "r");
    if (input_file == NULL) {
        fprintf(stderr, "Error opening input file\n");
        return 1;
    }

    fscanf(input_file, "%d %d %d", &x_dim, &y_dim, &sim_time);
    num_particles = 0;
    while (fscanf(input_file, "%d,%d,%d,%d", &particles[num_particles].x, &particles[num_particles].y,
                  &particles[num_particles].vx, &particles[num_particles].vy) != EOF) {
        num_particles++;
    }
    fclose(input_file);

    // Simulate particles
    simulate_particles(x_dim, y_dim, sim_time, particles, num_particles);

    // Print output
    print_output(x_dim, y_dim, particles, num_particles);

    return 0;
}