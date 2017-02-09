package com.andrijans.playground.framework.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by andrijanstankovic on 09/02/2017.
 */

public class Card implements Serializable {
    @SerializedName("cardId") private String cardId;
    @SerializedName("name") private String name;
    @SerializedName("cardSet") private String cardSet;
    @SerializedName("type") private String type;
    @SerializedName("text") private String text;
    @SerializedName("locale") private String locale;
    @SerializedName("playerClass") private String playerClass;
    @SerializedName("mechanics") private ArrayList<Mechanic> mechanics = new ArrayList<>();
    @SerializedName("faction") private String faction;
    @SerializedName("rarity") private String rarity;
    @SerializedName("health") private Integer health;
    @SerializedName("collectible") private Boolean collectible;
    @SerializedName("img") private String img;
    @SerializedName("imgGold") private String imgGold;
    @SerializedName("attack") private Integer attack;
    @SerializedName("race") private String race;
    public String getCardId() {
        return cardId;
    }
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCardSet() {
        return cardSet;
    }
    public void setCardSet(String cardSet) {
        this.cardSet = cardSet;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getLocale() {
        return locale;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }
    public String getPlayerClass() {
        return playerClass;
    }
    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }
    public ArrayList<Mechanic> getMechanics() {
        return mechanics;
    }
    public void setMechanics(ArrayList<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }
    public String getFaction() {
        return faction;
    }
    public void setFaction(String faction) {
        this.faction = faction;
    }
    public String getRarity() {
        return rarity;
    }
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
    public Integer getHealth() {
        return health;
    }
    public void setHealth(Integer health) {
        this.health = health;
    }
    public Boolean getCollectible() {
        return collectible;
    }
    public void setCollectible(Boolean collectible) {
        this.collectible = collectible;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getImgGold() {
        return imgGold;
    }
    public void setImgGold(String imgGold) {
        this.imgGold = imgGold;
    }
    public Integer getAttack() {
        return attack;
    }
    public void setAttack(Integer attack) {
        this.attack = attack;
    }
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public class Mechanic implements Serializable {
        @SerializedName ("name")
        private String name;
        /**
         * @return The name
         */
        public String getName() {
            return name;
        }
        /**
         * @param name The name
         */
        public void setName(String name) {
            this.name = name;
        }
    }
}
