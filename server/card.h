#ifndef CARD_H
#define CARD_H

enum class CardSuit {
  CLUBS = 0,
  DIAMONDS = 1,
  HEARTS = 2,
  SPADES = 3,
  NO_TRUMPS = 4
};

enum class CardType {
  TWO = 2,
  THREE = 3,
  FOUR = 4,
  FIVE = 5,
  SIX = 6,
  SEVEN = 7,
  EIGHT = 8,
  NINE = 9,
  TEN = 10,
  JACK = 11,
  QUEEN = 12,
  KING = 13,
  ACE = 14
};

class Card {
public:
  CardType type;
  CardSuit suit;

public:
  Card(CardSuit, CardType);
};

#endif // CARD_H
