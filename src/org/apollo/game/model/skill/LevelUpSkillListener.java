package org.apollo.game.model.skill;

import org.apollo.game.model.Graphic;
import org.apollo.game.model.Player;
import org.apollo.game.model.Skill;
import org.apollo.game.model.SkillSet;
import org.apollo.util.LanguageUtil;

/**
 * A {@link SkillListener} which notifies the player when they have leveled up
 * a skill.
 * @author Graham
 */
public final class LevelUpSkillListener extends SkillAdapter {

	/**
	 * The player.
	 */
	private final Player player;

	/**
	 * Creates the level up listener for the specified player.
	 * @param player The player.
	 */
	public LevelUpSkillListener(Player player) {
		this.player = player;
	}

	@Override
	public void levelledUp(SkillSet set, int id, Skill skill) {
		// TODO show the interface
		String name = Skill.getName(id);
		String article = LanguageUtil.getIndefiniteArticle(name);
		player.sendMessage("You've just advanced " + article + " " + name + " level! You have reached level " + skill.getMaximumLevel() + ".");
		player.playGraphic(new Graphic(199, 0, 100));
	}

}
