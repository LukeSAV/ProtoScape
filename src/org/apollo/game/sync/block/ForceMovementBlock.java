package org.apollo.game.sync.block;

import org.apollo.game.model.Position;

/**
 * The Force Movement {@link SynchronizationBlock}.
 * 
 * @note This block is used to force a {@link Player} to walk to a set location.
 *       The player can then perform an action (e.g. an animation), as used in
 *       the Agility skill, hence this block earning the name 'Asynchronous
 *       Animation/Walking', although the action is not restricted to
 *       animations.
 * 
 * @author Major
 */
public class ForceMovementBlock extends SynchronizationBlock {

    /**
     * The initial {@link Position} of the {@link Player}.
     */
    private final Position initialPosition;
    /**
     * The {@link Position} the {@link Player} is being moved to.
     */
    private final Position finalPosition;
    /**
     * The speed the {@link Player} is moving from initial X -> final X.
     */
    private final int speedX;
    /**
     * The speed the {@link Player} is moving from initial Y -> final Y.
     */
    private final int speedY;
    /**
     * The direction the {@link Player} is moving.
     */
    private final int direction;

    /**
     * Creates a new Force Movement block.
     * 
     * @param initialPosition
     *            The initial {@link Position} of the {@link Player}.
     * @param finalPosition
     *            The final {@link Position} of the {@link Player}
     * @param speedX
     *            The speed the {@link Player} should move, from initial X ->
     *            final X.
     * @param speedY
     *            The speed the {@link Player} should move, from initial Y ->
     *            final Y.
     * @param direction
     *            The direction the {@link Player} should move.
     */
    public ForceMovementBlock(Position initialPosition, Position finalPosition,
            int speedX, int speedY, int direction) {
        this.initialPosition = initialPosition;
        this.finalPosition = finalPosition;
        this.speedX = speedX;
        this.speedY = speedY;
        this.direction = direction;
    }

    /**
     * Gets the initial position. This shouldn't be used to get the initial X
     * and Y coordinates, see {@link #getInitialX()} and {@link #getInitialY()}.
     * 
     * @return The initial {@link Position}.
     */
    public Position getInitialPosition() {
        return initialPosition;
    }

    /**
     * Gets the final position. This shouldn't be used to get the initial X and
     * Y coordinates, see {@link #getFinalX()} and {@link #getFinalY()}.
     * 
     * @return The final {@link Position}.
     */
    public Position getFinalPosition() {
        return finalPosition;
    }

    /**
     * Gets the X coordinate of the initial {@link Position}.
     * 
     * @return The X coordinate.
     */
    public int getInitialX() {
        return initialPosition.getX();
    }

    /**
     * Gets the Y coordinate of the initial {@link Position}.
     * 
     * @return The Y coordinate.
     */
    public int getInitialY() {
        return initialPosition.getY();
    }

    /**
     * Gets the X coordinate of the final {@link Position}.
     * 
     * @return The X coordinate.
     */
    public int getFinalX() {
        return finalPosition.getX();
    }

    /**
     * Gets the Y coordinate of the final {@link Position}.
     * 
     * @return The Y coordinate.
     */
    public int getFinalY() {
        return finalPosition.getY();
    }

    /**
     * Gets the speed the {@link Player} should move initial X -> final X.
     * 
     * @return The speed.
     */
    public int getSpeedX() {
        return speedX;
    }

    /**
     * Gets the speed the {@link Player} should move from initial Y -> final Y.
     * 
     * @return The speed.
     */
    public int getSpeedY() {
        return speedY;
    }

    /**
     * Gets the direction the {@link Player} should move.
     * 
     * @return The direction.
     */
    public int getDirection() {
        return direction;
    }
}