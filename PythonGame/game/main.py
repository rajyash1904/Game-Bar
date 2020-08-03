#!/usr/bin/python

import pygame
from pathlib import Path
import random
import math
from pygame import mixer


pygame.init()

width = 800
height = 600
screen = pygame.display.set_mode((width, height))
pygame.display.set_caption("Space Invaders")


is_gameover = False

path = Path(__file__) #get path of current file(main.py)
game_dir = path.parent #path of parent i.e. directory game
image_dir = game_dir.joinpath('images') #path of image folder
sound_dir = game_dir.joinpath('sounds') #path of sound folder
score_val = 0

icon_path = image_dir.joinpath('spaceship.png') #path of actual image spaceshipp.png
icon = pygame.image.load(str(icon_path))
pygame.display.set_icon(icon)

player_x = (width//2)-32
player_y = height-80

player_image_path = image_dir.joinpath('player.png')
player_image = pygame.image.load(str(player_image_path))

bg_image_path = image_dir.joinpath('background.png')
bg_image = pygame.image.load(str(bg_image_path))


def collison(x1, y1, x2, y2):
    dist = math.sqrt(math.pow((x1-x2), 2) + math.pow((y1-y2), 2))

    if(dist<35):
        return True

    return False        



def insert_player(x, y):
    screen.blit(player_image, (round(x), round(y)))


player_x_change = 0
player_y_change = 0
DELTA_PLAYER = 2


enemy_x = []
enemy_y = []
enemies = []
enemy_x_change = []

enemy_1_image_path = image_dir.joinpath('enemy_1.png')
enemy_1_image = pygame.image.load(str(enemy_1_image_path))

enemy_2_image_path = image_dir.joinpath('enemy_2.png')
enemy_2_image = pygame.image.load(str(enemy_2_image_path))

enemy_3_image_path = image_dir.joinpath('enemy_3.png')
enemy_3_image = pygame.image.load(str(enemy_3_image_path))

enemy_4_image_path = image_dir.joinpath('enemy_4.png')
enemy_4_image = pygame.image.load(str(enemy_4_image_path))



enemies_image = [enemy_1_image, enemy_2_image, enemy_3_image, enemy_4_image]
index = 0
# enemy_y_change = []
delta_enemy = 3
num_of_enemies = 6

for i in range(num_of_enemies):
    
    index = random.randint(0, 3)
    enemies.append(enemies_image[index])
    
    enemy_x.append(random.randint(0, 720))
    enemy_y.append(random.randint(20, 300))
    enemy_x_change.append(delta_enemy)
    # enemy_y_change.append(0)

def insert_enemies(enemy, x, y):
    screen.blit(enemy, (round(x), round(y)))

bullet_image_path = image_dir.joinpath('bullet.png')
bullet_image = pygame.image.load(str(bullet_image_path))

bullet_x = 0
bullet_y = -100
bullet_state = "ready"
delta_bullet = 4

def fire_bullet(x, y):
    screen.blit(bullet_image, (round(x), round(y)))

font_score = pygame.font.Font('freesansbold.ttf', 32)
font_score_x = 10
font_score_y = 10

def show_score(x, y):
    score = font_score.render("Score: {}".format(score_val), True, (255, 255, 255))
    screen.blit(score, (x, y))


font__over = pygame.font.Font('freesansbold.ttf', 64)
font_over_x = 300
font_over_y = 250


def game_over(x, y):
    global is_gameover
    is_gameover=True
    score = font_score.render("GAME OVER", True, (255, 255, 255))
    screen.blit(score, (x, y))
    
bg_sound_path = sound_dir.joinpath('background.wav')
mixer.music.load(str(bg_sound_path))
mixer.music.play(-1)


prev_score = 0
curr_score = 0

running = True
while running:

    # screen.fill((255, 102, 53))
    # screen.fill((0, 0, 0))
    screen.blit(bg_image, (0, 0))

    if is_gameover:
        game_over(font_over_x, font_over_y)
        
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
        continue

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_RIGHT:
                player_x_change = delta_player
            if event.key == pygame.K_LEFT:
                player_x_change = -delta_player
            if event.key == pygame.K_SPACE:
                if(bullet_state=="ready"):
                    bullet_x = player_x+16
                    bullet_y = player_y+10
                    fire_sound_path = sound_dir.joinpath('bullet_fire.wav')
                    fire_sound = mixer.Sound(str(fire_sound_path))
                    fire_sound.play()
                    fire_bullet(bullet_x, bullet_y)
                    bullet_state = "fired"
            # if event.key == pygame.K_UP:
            #     player_y_change = -delta_player
            # if event.key == pygame.K_DOWN:
            #     player_y_change = delta_player

        if event.type == pygame.KEYUP:
                player_x_change = 0
                # player_y_change = 0

    
    player_x+=player_x_change
    # player_y+=player_y_change

    if(player_x>width-80):
        player_x = width - 80
    if(player_x<20):
        player_x = 20
    # if(player_y>height-80):
    #     player_y = height - 80
    # if(player_y<20):
    #     player_y = 20
    
    # curr_time = time.time()
    curr_score = score_val
    if(curr_score-prev_score>5):
        prev_score = curr_score
        delta_enemy+=0.5
        delta_bullet+=0.5

    for i in range(num_of_enemies):
        
        if(collison(player_x, player_y, enemy_x[i], enemy_y[i])):

            for j in range(num_of_enemies):
                enemy_y[j] = 2000
                player_y = 2000
            
            game_over(font_over_x, font_over_y)
            
            break

        if not collison(bullet_x, bullet_y, enemy_x[i], enemy_y[i]):

            enemy_x[i]+=enemy_x_change[i]
            

            if(enemy_x[i]>736):
                enemy_x[i] = 736
                enemy_x_change[i] = -delta_enemy
                enemy_y[i]+=20
            
            if(enemy_x[i]<0):
                enemy_x[i] = 0
                enemy_x_change[i] = delta_enemy
                enemy_y[i]+=20
        else:
            
            collision_sound_path = sound_dir.joinpath('collision.wav')
            collision_sound = mixer.Sound(str(collision_sound_path))
            collision_sound.play()
            
            score_val+=1
            index = random.randint(0, 3)
            enemies[i] = enemies_image[index]
            enemy_x[i] = random.randint(0, 720)
            enemy_y[i] = random.randint(20, 200)
            bullet_state = "ready"
            bullet_x = 0
            bullet_y = -100

        
        insert_enemies(enemies[i], enemy_x[i], enemy_y[i])
        

    if bullet_y<=0:
        bullet_y = player_y+10
        bullet_state = "ready"

    if(bullet_state=="fired"):
        bullet_y-= delta_bullet
        fire_bullet(bullet_x, bullet_y)
    
    insert_player(player_x, player_y)
    show_score(font_score_x, font_score_y)
    
    pygame.display.update()
