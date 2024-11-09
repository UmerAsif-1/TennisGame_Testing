import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		// This statement should cause an exception
		game.player1Scored();			
	}
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		// This statement should cause an exception
		game.player2Scored();			
	}
	@Test
	public void testTennisGame_Player1WinsGame()throws TennisGameException  {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
	    assertEquals("Player 1 should win","player1 wins", score);
	    		
	}	
	@Test
	public void testTennisGame_Player2WinsGame()throws TennisGameException  {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
	    assertEquals("Player 2 should win","player2 wins", score);
	    		
	}	
	@Test 
    public void testTennisGame_Player1HasAdvantage() throws TennisGameException {
        // Arrange
        TennisGame game = new TennisGame();

        //player 1 scored
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();

        // player 2 scored
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();

        // Player 1 scores the next point
        game.player1Scored();

        // Act
        String score = game.getScore();

        // Assert
        assertEquals("Player 1 should have advantage", "player1 has advantage", score);
    }
	@Test 
    public void testTennisGame_Player2HasAdvantage() throws TennisGameException {
        // Arrange
        TennisGame game = new TennisGame();

        //player 1 scored
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();

        // player 2 scored
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();

        // Player 1 scores the next point
        game.player2Scored();

        // Act
        String score = game.getScore();

        // Assert
        assertEquals("Player 2 should have advantage", "player2 has advantage", score);
    }


}
