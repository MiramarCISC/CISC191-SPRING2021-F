package edu.sdccd.cisc191.f;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sdccd.cisc191.f.server.cards.Card;
import edu.sdccd.cisc191.f.server.cards.Deck;

public class PlayerResponse {
    private Integer id;
    protected int energy;
    protected int gold;
    protected Deck<Card> deck;

    @JsonIgnore
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String toJSON(PlayerResponse player) throws Exception {
        return objectMapper.writeValueAsString(player);
    }

    public static PlayerResponse fromJSON(String input) throws Exception{
        return objectMapper.readValue(input, PlayerResponse.class);
    }

    protected PlayerResponse() {}

    public PlayerResponse(Integer id, int energy, int gold) {
        this.id = id;
        this.energy = energy;
        this.gold = gold;
    }

    @Override
    public String toString() {
        return String.format(
                "Player[id=%d, energy='%d', gold='%d']",
                id, energy, gold);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Deck<Card> getDeck() {
        return deck;
    }

    public void setDeck(Deck<Card> deck) {
        this.deck = deck;
    }
}
