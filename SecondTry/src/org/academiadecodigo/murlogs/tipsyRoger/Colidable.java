package org.academiadecodigo.murlogs.tipsyRoger;

public abstract class Colidable {

    private boolean isColliding;

    protected boolean rightCollision;
    protected boolean leftCollision;
    protected boolean topCollision;
    protected boolean botCollision;

    public boolean predictRightColision(Colidable colidable) {
        if (x() < colidable.xToWidth() &&
                xToWidth() + 1 > colidable.x() &&
                y() < colidable.yToHeight() &&
                yToHeight() > colidable.y()) {
            rightCollision = true;
            return true;
        }
        rightCollision = false;
        return false;
    }

    public boolean predictLeftColision(Colidable colidable) {
        if (x() - 1 < colidable.xToWidth() &&
                xToWidth() > colidable.x() &&
                y() < colidable.yToHeight() &&
                yToHeight() > colidable.y()) {
            leftCollision = true;
            return true;
        }
        leftCollision = false;
        return false;
    }

    public boolean predictTopCollision(Colidable colidable) {
        if (x() < colidable.xToWidth() &&
                xToWidth() > colidable.x() &&
                y() - 1 < colidable.yToHeight() &&
                yToHeight() > colidable.y()) {
            topCollision = true;
            return true;
        }
        topCollision = false;
        return false;
    }

    public boolean predictBotCollision(Colidable colidable) {
        if (x() < colidable.xToWidth() &&
                xToWidth() > colidable.x() &&
                y() < colidable.yToHeight() &&
                yToHeight() + 1 > colidable.y()) {
            botCollision = true;
            return true;
        }
        botCollision = false;
        return false;
    }

    public boolean checkColision(Colidable colidable) {
        if (x() < colidable.xToWidth() &&
                xToWidth() > colidable.x() &&
                y() < colidable.yToHeight() &&
                yToHeight() > colidable.y()) {
            isColliding = true;
            return true;
        }
        isColliding = false;
        return false;
    }

    public abstract void draw();

    public abstract int y();

    public abstract int x();

    public abstract int yToHeight();

    public abstract int xToWidth();

}
