
-- File: games.sql
-- Description: sql file to create game database
-- Version: 1
-- Date created: 2017-02-03
-- All the pictures are courtesy of Wikipedia(https://www.wikipedia.com), Shuttersock(https://www.shutterstock.com), http://roulettegamesvariety.com/drinking-roulette.htm.
-- Other pictures are from
-- Pop-at-a-shot basketball(http://www.popashot.net/)
-- Barkeno picture (http://www.stamfordadvocate.com/local/article/Keno-gambling-game-debuts-at-Stamford-bar-7382117.php)
-- Big Buck Hunter(http://www.skidrowpcgames.com/big-buck-hunter-arcade-free-download/)
-- Ring on a string game(https://tropicalogy.com/hooked-surfing-hook-ring-game/)

-- Initial creation for tables
CREATE TABLE IF NOT EXISTS GAMEITEM{
	game_id  INTEGER PRIMARY KEY AUTOINCREMENT,
	game_title TEXT NOT NULL ,
	user_defined INTEGER DEFAULT 0 , 
};

CREATE TABLE IF NOT EXISTS GAMEITEMDESC{
	gameitem_id INTEGER PRIMARY KEY,
	game_id INTEGER NOT NULL,
	game_desc TEXT NOT NULL,
	gameRules_Path TEXT,
	gameIcon_Path TEXT,
	foreign key(game_id) references GAMEITEM(game_id) ON DELETE CASCADE ON UPDATE CASCADE
};


-- Initial creation for values
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('0', 'Darts');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('1', 'Uno');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('2', 'ShuffleBoard(table-top)');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('3', 'Trivial Pursuit');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('4', 'Pool');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('5', 'Jenga');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('6', 'Cornhole');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('7', 'Cards Against Humanity');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('8', 'Bar Roulette');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('9', 'Cribbage');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('10', 'Pop-A-Shot-Basketball');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('11', 'Buck Hunter');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('12', 'Foosball');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('13', 'Dice');
INSERT INTO GAMEITEM(game_id, game_title, user_defined) VALUES ('14', 'Ring on a string');

INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path) 
VALUES('1', '0', 'A form of throwing sport in which a circular board is peppered with missiles that are lightweight and small', 'rules/darts.pdf', 'images/darts.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '1', 'A form of cards game where the objective is to be the first to get rid of all your cards before the others dispose of theirs', 'rules/uno.pdf', 'images/uno.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '2', 'A game in which a smooth and wooden table is divided into scoring zones where metal-and-plastic weighted pucks are pushed into by players, from one end of the table', 'rules/tableshuffle.pdf', 'images/tableshuffle.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '3', 'A form of board that tests your knownlegde of trivia', 'rules/trivial.pdf', 'images/trivial.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '4', 'A form of cue sports where the objective is to push the balls across a table, along the rails, into the six pockets of the table', 'rules/pool.pdf', 'images/pool.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '5', 'A form of blocks game where players try to build a progressively taller structure with 54 blocks', 'rules/jenga.pdf', 'images/jenga.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '6', 'A form of throwing sport where bags of small smooth balls are thrown at a raised platform with a hole in the far end', 'rules/cornhole.pdf', 'images/cornhole.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '7', 'A form of cards game where players give answers to questions where the answers could be considered as offensive, risqué or politically incorrect', 'rules/cardshumanity.pdf', 'images/cardshumanity.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '8', 'A spin of the classic roulette where the objective is to be the last one standing after drinking rounds from glasses placed in a wheel', 'rules/barroulette.pdf', 'images/barroulette.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '9', 'A form of cards game where a board with a series of holes is used to keep score', 'rules/cribbage.pdf', 'images/cribbage.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '10', 'A form of indoor basketball where there is a plastic trough which collects the basketball after it is thrown at the hoop', 'rules/popashotbasketball.pdf', 'images/popashotbasketball.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '11', 'A form of an arcade hunting game where the objective is to avoid shooting a doe or female animal while shooting three bucks per stage', 'rules/buckhunter.pdf', 'images/buckhunter.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '12', 'A form of football where the playing field is on a table and the players use the stick figures on metal bars to move the ball towards opposing goalpost', 'rules/foosball.pdf', 'images/foosball.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '13', 'A form of dice game that uses dice to determine who is going to be on the hook for the next round of drinks', 'rules/bardice.pdf', 'images/bardice.png');
INSERT INTO GAMEITEMDESC(gameitem_id, game_id, game_desc, gameRules_Path, gameIcon_Path)
VALUES('1', '14', 'A form of dice game that uses dice to determine who is going to be on the hook for the next round of drinks', 'rules/ringstring.pdf', 'images/ringstring.png');