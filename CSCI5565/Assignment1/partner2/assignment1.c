#include <stdio.h>
#include <stdbool.h> // Include the header file for bool type
#include <stdlib.h>
#include <string.h>

#define MAX_PARTICLES 1000 // Define a maximum number of particles

typedef struct {
    int x, y; // Position of the particle
    int vx, vy; // Velocity of the particle
    bool active; // Flag to indicate whether the particle is active or removed
} Particle;

// Function prototypes
void simulateParticles(Particle particles[], int numParticles, int maxX, int maxY, int simTime);
bool checkCollision(Particle particles[], int numParticles);
void printGrid(FILE *outputFile, Particle particles[], int numParticles, int maxX, int maxY);

// Function to simulate particle movement
void simulateParticles(Particle particles[], int numParticles, int maxX, int maxY, int simTime) {
    for (int t = 0; t < simTime; t++) {
        // Update particle positions
        for (int i = 0; i < numParticles; i++) {
            particles[i].x += particles[i].vx;
            particles[i].y += particles[i].vy;

            // Handle boundary conditions
            if (particles[i].x < 0 || particles[i].x >= maxX) {
                particles[i].x = particles[i].x < 0 ? 0 : maxX - 1;
                particles[i].vx = -particles[i].vx;
            }
            if (particles[i].y < 0 || particles[i].y >= maxY) {
                particles[i].y = particles[i].y < 0 ? 0 : maxY - 1;
                particles[i].vy = -particles[i].vy;
            }
        }
         // Print particle positions after each move
       /* for (int i = 0; i < numParticles; i++) {
            printf("Particle %d: (%d, %d)\n", i + 1, particles[i].x, particles[i].y);
        }*/
        
        // Check for collisions after updating particle positions
        if (checkCollision(particles, numParticles)) {
            // Remove collided particles from the system
            int k = 0;
            for (int i = 0; i < numParticles; i++) {
                if (particles[i].active) {
                    particles[k++] = particles[i];
                }
            }
            numParticles = k;
        }
    }
}

// Function to check if two particles collide
bool checkCollision(Particle particles[], int numParticles) {
    for (int i = 0; i < numParticles; i++) {
        for (int j = i + 1; j < numParticles; j++) {
            if (particles[i].x == particles[j].x && particles[i].y == particles[j].y) {
                // Particles collide, remove both particles from the system
                particles[i].active = false; // Mark particle as removed
                particles[j].active = false; // Mark particle as removed
                return true; // Collision detected
            }
        }
    }
    return false; // No collision detected
}

// Main function
int main() {
    FILE *inputFile = fopen("input.txt", "r");
    FILE *outputFile = fopen("output.txt", "w");
    
    if (inputFile == NULL || outputFile == NULL) {
        if (outputFile != NULL) {
            fprintf(outputFile, "Error: Unable to open input file.\n");
            fclose(outputFile);
        } else {
            fprintf(stdout, "Error: Unable to open both input and output files.\n");
        }
        return 1;
    }

    int maxX, maxY, simTime;
    if (fscanf(inputFile, "%d%d%d", &maxX, &maxY, &simTime) != 3) {
        fprintf(outputFile,"Error: Invalid input format for dimensions.\n");
        fclose(inputFile);
        fclose(outputFile);
        return 1;
    }
    
    
    if (maxX <= 0 || maxY <= 0) {
        fprintf(outputFile,"Error: Dimensions cannot be zero or negative.\n");
        fclose(inputFile);
        fclose(outputFile);
        return 1;
    }

    Particle particles[MAX_PARTICLES];
    int numParticles = 0;
    while (true) {
        int x, y, vx, vy;
        if (fscanf(inputFile, "%d,%d,%d,%d", &x, &y, &vx, &vy) != 4)
            break;
        if (x < 0 || x >= maxX || y < 0 || y >= maxY) {
            fprintf(outputFile,"Error: Particle coordinates are out of bounds.\n");
            fclose(inputFile);
            fclose(outputFile);
            return 1;
        }
        particles[numParticles].x = x;
        particles[numParticles].y = y;
        particles[numParticles].vx = vx;
        particles[numParticles].vy = vy;
        particles[numParticles].active = true; // Mark particle as active
        numParticles++;
    }

    fclose(inputFile);

    if (numParticles == 0) {
        fprintf(outputFile,"Error: No particles found in input file.\n");
        fclose(outputFile);
        return 1;
    }
    
    simulateParticles(particles, numParticles, maxX, maxY, simTime);

    // Output the final grid
    printGrid(outputFile, particles, numParticles, maxX, maxY);

    fclose(outputFile);

    return 0;
}

// Function to print the final grid with particles
void printGrid(FILE *outputFile, Particle particles[], int numParticles, int maxX, int maxY) {
    for (int y = maxY; y > -2 ; y--) {
        for (int x = -1; x < maxX+1; x++) {
            bool isParticle = false;
            for (int i = 0; i < numParticles; i++) {
                if (particles[i].active && particles[i].x == x && particles[i].y == y) {
                    fprintf(outputFile, "+");
                    isParticle = true;
                    break;
                }
            }
            if (!isParticle) {
                if (x == -1 || y == -1|| x == maxX  || y == maxY ) {
                    fprintf(outputFile, "*");
                } else {
                    fprintf(outputFile, " ");
                }
            }
        }
        if(y != -1){
        fprintf(outputFile, "\n");
        }
    }
}