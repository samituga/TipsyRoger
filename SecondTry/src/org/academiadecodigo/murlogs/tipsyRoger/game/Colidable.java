package org.academiadecodigo.murlogs.tipsyRoger.game;

public abstract class Colidable {

    protected boolean rightCollision;
    protected boolean leftCollision;
    protected boolean topCollision;
    protected boolean botCollision;

    protected boolean predictRightCollision(Colidable colidable) {
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

    protected boolean predictLeftCollision(Colidable colidable) {
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

    protected boolean predictTopCollision(Colidable colidable) {
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

    protected boolean predictBotCollision(Colidable colidable) {
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

    public boolean checkCollision(Colidable colidable) {
        if (x() < colidable.xToWidth() &&
                xToWidth() > colidable.x() &&
                y() < colidable.yToHeight() &&
                yToHeight() > colidable.y()) {
            return true;
        }
        return false;
    }

    public abstract void draw();

    public abstract int y();

    public abstract int x();

    public abstract int yToHeight();

    public abstract int xToWidth();

}
