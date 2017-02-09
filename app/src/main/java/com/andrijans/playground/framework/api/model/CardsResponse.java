package com.andrijans.playground.framework.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CardsResponse {
    @SerializedName ("Basic") public ArrayList<Card> basic;
    @SerializedName ("Classic") public ArrayList<Card> classic;
    @SerializedName ("Credits") public ArrayList<Card> credits;
    @SerializedName ("Naxxramas") public ArrayList<Card> naxxramas;
    @SerializedName ("Goblins vs Gnomes") public ArrayList<Card> GvG;
    @SerializedName ("Missions") public ArrayList<Card> missions;
    @SerializedName ("Promotion") public ArrayList<Card> promotions;
    @SerializedName ("Reward") public ArrayList<Card> reward;
    @SerializedName ("System") public ArrayList<Card> system;
    @SerializedName ("Debug") public ArrayList<Card> debug;
    @SerializedName ("Blackrock Mountain") public ArrayList<Card> blackrockMountain;
    @SerializedName ("Hero Skins") public ArrayList<Card> heroSkins;
    @SerializedName ("Tavern Brawl") public ArrayList<Card> travernBrawl;
    @SerializedName ("The Grand Tournament") public ArrayList<Card> theGrandTournament;
    @SerializedName ("The League of Explorers") public ArrayList<Card> theLeagueOfExplorers;

    public ArrayList<Card> getBasic() {
        return basic;
    }

    public void setBasic(ArrayList<Card> basic) {
        this.basic = basic;
    }

    public ArrayList<Card> getClassic() {
        return classic;
    }

    public void setClassic(ArrayList<Card> classic) {
        this.classic = classic;
    }

    public ArrayList<Card> getCredits() {
        return credits;
    }

    public void setCredits(ArrayList<Card> credits) {
        this.credits = credits;
    }

    public ArrayList<Card> getNaxxramas() {
        return naxxramas;
    }

    public void setNaxxramas(ArrayList<Card> naxxramas) {
        this.naxxramas = naxxramas;
    }

    public ArrayList<Card> getGvG() {
        return GvG;
    }

    public void setGvG(ArrayList<Card> gvG) {
        GvG = gvG;
    }

    public ArrayList<Card> getMissions() {
        return missions;
    }

    public void setMissions(ArrayList<Card> missions) {
        this.missions = missions;
    }

    public ArrayList<Card> getPromotions() {
        return promotions;
    }

    public void setPromotions(ArrayList<Card> promotions) {
        this.promotions = promotions;
    }

    public ArrayList<Card> getReward() {
        return reward;
    }

    public void setReward(ArrayList<Card> reward) {
        this.reward = reward;
    }

    public ArrayList<Card> getSystem() {
        return system;
    }

    public void setSystem(ArrayList<Card> system) {
        this.system = system;
    }

    public ArrayList<Card> getBlackrockMountain() {
        return blackrockMountain;
    }

    public void setBlackrockMountain(ArrayList<Card> blackrockMountain) {
        this.blackrockMountain = blackrockMountain;
    }

    public ArrayList<Card> getHeroSkins() {
        return heroSkins;
    }

    public void setHeroSkins(ArrayList<Card> heroSkins) {
        this.heroSkins = heroSkins;
    }

    public ArrayList<Card> getTravernBrawl() {
        return travernBrawl;
    }

    public void setTravernBrawl(ArrayList<Card> travernBrawl) {
        this.travernBrawl = travernBrawl;
    }

    public ArrayList<Card> getTheGrandTournament() {
        return theGrandTournament;
    }

    public void setTheGrandTournament(ArrayList<Card> theGrandTournament) {
        this.theGrandTournament = theGrandTournament;
    }

    public ArrayList<Card> getTheLeagueOfExplorers() {
        return theLeagueOfExplorers;
    }

    public void setTheLeagueOfExplorers(ArrayList<Card> theLeagueOfExplorers) {
        this.theLeagueOfExplorers = theLeagueOfExplorers;
    }

    public ArrayList<Card> getDebug() {
        return debug;
    }

    public void setDebug(ArrayList<Card> debug) {
        this.debug = debug;
    }
}