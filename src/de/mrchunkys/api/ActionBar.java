package de.mrchunkys.api;

import org.bukkit.entity.Player;

import me.confuser.barapi.BarAPI;

public class ActionBar {

	private Player player;
	private String message;

	public ActionBar(Player player, String message) {
		this.player = player;
		this.message = message;
	}

	public void sendPlayerAnnouncement() {
		BarAPI.setMessage(this.player, this.message);
	}
}
