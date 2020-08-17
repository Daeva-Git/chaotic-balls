package com.rockbite.bootcamp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Ball {
    private float xPos;
    private float yPos;
    private float xSpeed;
    private float ySpeed;
    private float mass;
    private float radius;
    private Color color;

    public Ball(float xPos, float yPos, float xSpeed, float ySpeed, float mass, float radius, Color color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.mass = mass;
        this.radius = radius;
        this.color = color;
    }


    public void update() {
        setxPos(xPos + xSpeed);
        setyPos(yPos + ySpeed);
        if (xPos == radius || xPos == Gdx.graphics.getWidth() - radius) {
            setxSpeed(-xSpeed);
        }
        if (yPos == radius || yPos == Gdx.graphics.getHeight() - radius) {
            setySpeed(-ySpeed);
        }
    }
    public void draw(ShapeRenderer shape) {
        shape.circle(xPos, yPos, radius);
    }

    public void checkCollision(Ball ball) {
        if(collidesWith(ball)){
            ySpeed = - ySpeed;
            xSpeed = - xSpeed;
            ball.setySpeed(-ball.getySpeed());
            ball.setxSpeed(-ball.getxSpeed());
        }
    }

    private boolean collidesWith(Ball ball) {
        if(distance(ball) < radius + ball.getRadius()) return true;
        return false;
    }

    public float distance (Ball ball) {
        float distanceX = xPos - ball.getxPos();
        float distanceY = yPos - ball.getyPos();

        return (float)Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        if(xPos < radius) {
            this.xPos = radius;
        }
        else if(xPos > Gdx.graphics.getWidth() - radius) {
            this.xPos = Gdx.graphics.getWidth() - radius;
        }
        else this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        if(yPos < radius) {
            this.yPos = radius;
        }
        else if(yPos > Gdx.graphics.getHeight() - radius) {
            this.yPos = Gdx.graphics.getHeight() - radius;
        }
        else this.yPos = yPos;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float size) {
        this.radius = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor () {
        return color;
    }
}
