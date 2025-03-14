package com.scovings.main;

import java.awt.*;

public class Boss1 extends GameObject {

    private Handler handler;

    public Boss1(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 3; // Moves slower than BasicEnemy
        velY = 3;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 64, 64); // Bigger hitbox
    }

    public void tick() {
        x += velX;
        y += velY;

        // Bounce off walls (adjusted for larger size)
        if (y <= 0 || y >= Game.HEIGHT - 80) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 80) velX *= -1;

        // Leaves a bigger trail
        handler.addObject(new Trail((int)x, (int)y, ID.Trail, new Color(139, 0, 0), 64, 64, 0.05f, handler));
    }

    public void render(Graphics g) {
        g.setColor(new Color(139, 0, 0)); // Dark red color
        g.fillRect((int)x, (int)y, 64, 64);
    }
}
