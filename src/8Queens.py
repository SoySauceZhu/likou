

import random
import matplotlib.pyplot as plt


N = 8

random.seed(42)  # For reproducibility


def init():
    return random.sample(range(N), N)

def fitness(chromosome):
    attack_count = 0
    n = len(chromosome)
    for row in range(n):
        for col in range(row+1, n):
            if chromosome[row] == chromosome[col] or abs(chromosome[row] - chromosome[col]) == col - row:
                attack_count += 1
    return attack_count

def select(chromosome, score):
    tournament = random.sample(list(zip(chromosome, score)), 3) # int(len(chromosome) / 2))
    tournament.sort(key=lambda x: x[1], reverse=False)
    return tournament[0][0]     # return chromosome

def crossover(parent1, parent2):
    point = random.randint(1, N - 1)
    child1 = parent1[:point] + parent2[point:]
    child2 = parent2[:point] + parent1[point:]
    return child1, child2

def mutate(chromosome):
    i, j = random.sample(range(N), 2)
    chromosome[i], chromosome[j] = chromosome[j], chromosome[i]
    return chromosome

def genetic_algorithm(generations=1000, pop_size=100):
    global total

    population = [init() for _ in range(pop_size)]

    for gen in range(generations):
        scores = [fitness(i) for i in population]

        if min(scores) == 0:
            best = population[scores.index(min(scores))]
            print("Solution found in generation", gen)
            print("Chromosome:", best)
            return best

        new_population = []
        for _ in range(pop_size):
            mom = select(population, scores)
            dad = select(population, scores)
            child = crossover(mom, dad)[0]
            if random.random() < 0.1:
                child = mutate(child)
            new_population.append(child)
        population = new_population # [:pop_size]
    return population[scores.index(min(scores))]


def visualize(solution):
    board = [['⬜️' for _ in range(N)] for _ in range(N)]
    for row in range(N):
        board[row][solution[row]] = '♛'

    fig, ax = plt.subplots()
    ax.set_xticks(range(N))
    ax.set_yticks(range(N))
    ax.set_xticklabels([])
    ax.set_yticklabels([])
    ax.grid(True)

    for i in range(N):
        for j in range(N):
            color = 'white' if (i + j) % 2 == 0 else 'gray'
            rect = plt.Rectangle([j, N-1-i], 1, 1, facecolor=color)
            ax.add_patch(rect)
            if board[i][j] == '♛':
                ax.text(j + 0.5, N - 1 - i + 0.5, '♛', fontsize=20, ha='center', va='center')

    plt.show()



if __name__ == "__main__":
    solution = genetic_algorithm()
    print("Best solution:", solution)
    print("Fitness:", fitness(solution))
    print("Number of attacks:", 28 - fitness(solution))  # 28 is the maximum number of attacks in an 8-queens problem
    print("Queens positions:", [(i, solution[i]) for i in range(N)])
    print("Queens on board:")
    for i in range(N):
        row = ['.'] * N
        row[solution[i]] = 'Q'
        print(' '.join(row))
        
    visualize(solution)
        

    