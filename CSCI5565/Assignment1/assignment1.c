#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x, y;          // Position
    int vx, vy;        // Velocity
    int collided;      // Collision status, 1 if collided, 0 otherwise
} Particle;


void readInputFile(const char* filename, int* gridX, int* gridY, int* simTime, Particle** particles, int* numParticles) {
    FILE* file = fopen(filename, "r");
    if (!file) {
        perror("Error opening file");
        exit(1);
    }

    fscanf(file, "%d%d%d", gridX, gridY, simTime);

    *particles = (Particle*)malloc(sizeof(Particle) * 5); // Assuming max 5 particles for simplicity
    *numParticles = 0;

    while (fscanf(file, "%d,%d,%d,%d", &((*particles)[*numParticles].x), &((*particles)[*numParticles].y), &((*particles)[*numParticles].vx), &((*particles)[*numParticles].vy)) == 4) {
        (*particles)[*numParticles].collided = 0;
        (*numParticles)++;
    }

    fclose(file);
}

void updatePosition(Particle* particle, int gridX, int gridY) {
    particle->x += particle->vx;
    particle->y += particle->vy;

    // Handle boundary collisions
    if (particle->x < 0 || particle->x >= gridX) {
        particle->vx *= -1;
        particle->x += particle->vx * 2; // Correct position after bounce
    }
    if (particle->y < 0 || particle->y >= gridY) {
        particle->vy *= -1;
        particle->y += particle->vy * 2; // Correct position after bounce
    }
}

void checkCollisions(Particle* particles, int numParticles) {
    for (int i = 0; i < numParticles; i++) {
        if (particles[i].collided) continue; // Skip already collided particles

        for (int j = i + 1; j < numParticles; j++) {
            if (particles[j].collided) continue;

            if (particles[i].x == particles[j].x && particles[i].y == particles[j].y) {
                // Mark both particles as collided
                particles[i].collided = 1;
                particles[j].collided = 1;
                break;
            }
        }
    }
}

void runSimulation(Particle* particles, int numParticles, int gridX, int gridY, int simTime) {
    for (int t = 0; t < simTime; t++) {
        for (int i = 0; i < numParticles; i++) {
            if (!particles[i].collided) {
                updatePosition(&particles[i], gridX, gridY);
            }
        }
        checkCollisions(particles, numParticles);
    }
}

void writeOutputFile(const char* filename, Particle* particles, int numParticles, int gridX, int gridY) {
    FILE* file = fopen(filename, "w");
    if (!file) {
        perror("Error opening file");
        exit(1);
    }
    

    
    
    if (gridX <= 0 || gridX <= 0) {
        fprintf(file,"Error: Dimensions cannot be zero or negative.\n");
        fclose(file);
        
    }
  
    if (particles->x < 0 || particles->x >= gridX || particles->y < 0 || particles->y >= gridY) {
            fprintf(file,"Error: Particle coordinates are out of bounds.\n");
            fclose(file);
            
    }

    // Print grid with particles
    for (int y = -1; y <= gridY; y++) {
        for (int x = -1; x <= gridX; x++) {
            if (x == -1 || x == gridX || y == -1 || y == gridY) {
                fprintf(file, "*");
            } else {
                int printed = 0;
                for (int i = 0; i < numParticles; i++) {
                    if (!particles[i].collided && particles[i].x == x && (gridY-particles[i].y-1 == y)) {
                        fprintf(file, "+");
                        printed = 1;
                        break;
                    }
                }
                if (!printed) fprintf(file, " ");
            }
        }
        
        fprintf(file, "\n");
    }

    fclose(file);
}

int main(int argc, char* argv[]) {
    if (argc < 3) {
        printf("Usage: %s <input_file> <output_file>\n", argv[0]);
        return 1;
    }

    int gridX, gridY, simTime, numParticles;
    Particle* particles;
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

    
    if (fscanf(inputFile, "%d%d%d", &gridX, &gridX, &simTime) != 3) {
        fprintf(outputFile,"Error: Invalid input format for dimensions.\n");
        fclose(inputFile);
        fclose(outputFile);
        return 1;
    }

    readInputFile(argv[1], &gridX, &gridY, &simTime, &particles, &numParticles);

    

    if (gridX <= 0 || gridY <= 0) {
        writeOutputFile(argv[2], particles, numParticles, gridX, gridY);
        
    }
    
    else if (particles->x < 0 || particles->x >= gridX || particles->y < 0 || particles->y >= gridY) {
        writeOutputFile(argv[2], particles, numParticles, gridX, gridY);
            
    }
    else{
    runSimulation(particles, numParticles, gridX, gridY, simTime);
    writeOutputFile(argv[2], particles, numParticles, gridX, gridY);
    }
    free(particles); // Clean up allocated memory
    return 0;
}
