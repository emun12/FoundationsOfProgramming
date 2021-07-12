package a7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ConnectFourWidget extends JPanel implements ActionListener, SpotListener{
	/* Enum to identify player. */

	private enum Player {RED, BLACK};

	private JSpotBoard _board;		/* SpotBoard playing area. */
	private JLabel _message;		/* Label for messages. */
	private boolean _game_won;		/* Indicates if games was been won already.*/
	private Spot _secret_spot;		/* Secret spot which wins the game. */
	private Color _secret_spot_bg;  /* Needed to reset the background of the secret spot. */
	private Player _next_to_play;	/* Identifies who has next turn. */

	public ConnectFourWidget() { 

		/* Create SpotBoard and message label. */

		_board = new JSpotBoard(7,6);

		for(Spot s: _board) {
			if(s.getSpotX() % 2 == 0 || s.getSpotX() == 0) {
				s.setBackground(Color.LIGHT_GRAY);
			} else {
				s.setBackground(Color.DARK_GRAY);
			}
			// for the uneven columns, the background will be dark gray.
			// for the even columns, the background will be light gray.
		}


		_message = new JLabel();

		/* Set layout and place SpotBoard at center. */

		setLayout(new BorderLayout());
		add(_board, BorderLayout.CENTER);

		/* Create subpanel for message area and reset button. */

		JPanel reset_message_panel = new JPanel();
		reset_message_panel.setLayout(new BorderLayout());

		/* Reset button. Add ourselves as the action listener. */

		JButton reset_button = new JButton("Restart");
		reset_button.addActionListener(this);
		reset_message_panel.add(reset_button, BorderLayout.EAST);
		reset_message_panel.add(_message, BorderLayout.CENTER);

		/* Add subpanel in south area of layout. */

		add(reset_message_panel, BorderLayout.SOUTH);

		/* Add ourselves as a spot listener for all of the
		 * spots on the spot board.
		 */
		_board.addSpotListener(this);

		/* Reset game. */
		resetGame();
	}

	/* resetGame
	 * 
	 * Resets the game by clearing all the spots on the board,
	 * picking a new secret spot, resetting game status fields, 
	 * and displaying start message.
	 * 
	 */

	private void resetGame() {
		/* Clear all spots on board. Uses the fact that SpotBoard
		 * implements Iterable<Spot> to do this in a for-each loop.
		 */

		for (Spot s : _board) {
			s.setSpotColor(Color.LIGHT_GRAY);
			s.clearSpot();
		}

		/* Reset the background of the old secret spot.
		 * Check _secret_spot for null first because call to 
		 * resetGame from constructor won't have a secret spot 
		 * chosen yet.
		 */

//		if (_secret_spot != null) {
//			_secret_spot.setBackground(_secret_spot_bg);
//		}

		/* Pick a new secret spot. */

//		int secret_x = (int) (Math.random() * _board.getSpotWidth());
//		int secret_y = (int) (Math.random() * _board.getSpotWidth());
//		_secret_spot = _board.getSpotAt(secret_x, secret_y);
//		_secret_spot_bg = _secret_spot.getBackground();

		/* Reset game won and next to play fields */
		_game_won = false;
		_next_to_play = Player.RED;		

		/* Display game start message. */

		_message.setText("Welcome to Connect Four. Red to play");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* Handles reset game button. Simply reset the game. */
		resetGame();
	}

	/* Implementation of SpotListener below. Implements game
	 * logic as responses to enter/exit/click on spots.
	 */

	@Override
	public void spotClicked(Spot s) {

		/* If game already won, do nothing. */
		if (_game_won) {
			return;
		}


		/* Set up player and next player name strings,
		 * and player color as local variables to
		 * be used later.
		 */

		String player_name = null;
		String next_player_name = null;
		Color player_color = null;

		int col = s.getSpotX();

		if(!_board.getSpotAt(col, 0).isEmpty()) {
			_message.setText("not allowed");
		}
		else {
			if (_next_to_play == Player.BLACK) {
				player_color = Color.BLACK;
				player_name = "Black";
				next_player_name = "Red";
				_next_to_play = Player.RED;
			} else {
				player_color = Color.RED;
				player_name = "Red";
				next_player_name = "Black";
				_next_to_play = Player.BLACK;			
			}
		}



		for(int i=5; i>=0; i--) {
			if(_board.getSpotAt(col, i).isEmpty()) {

				_board.getSpotAt(col, i).setSpotColor(player_color);
				_board.getSpotAt(col,  i).toggleSpot();
				_message.setText(next_player_name + " to play.");
				break;
			}
		}


		// Rows
		for(int i=0; !_game_won && i<4; i++) {
			// i<=5
			for(int j=0; !_game_won && j<6; j++) {
				if(!_board.getSpotAt(i, j).isEmpty()) {
					if(_board.getSpotAt(i, j).getSpotColor() == _board.getSpotAt(i+1, j).getSpotColor()) {
						if(_board.getSpotAt(i, j).getSpotColor() == _board.getSpotAt(i+2, j).getSpotColor()) {
							if(_board.getSpotAt(i, j).getSpotColor() == _board.getSpotAt(i+3, j).getSpotColor()) {
								_game_won = true;
								_message.setText(player_name + " wins!");
								
								for(Spot spot:_board) {
									spot.unhighlightSpot();
								}
								
								_board.getSpotAt(i,j).highlightSpot();
								_board.getSpotAt(i+1,j).highlightSpot();
								_board.getSpotAt(i+2,j).highlightSpot();
								_board.getSpotAt(i+3,j).highlightSpot();
								
								
							}
						}
					}
				}
			} 
		}
		
		// columns
		for(int i=0; !_game_won && i<7; i++) {
			for(int j=0; !_game_won && j<=2; j++) {
				// j<3
				if(!_board.getSpotAt(i, j).isEmpty()) {
					if(_board.getSpotAt(i, j).getSpotColor() == _board.getSpotAt(i, j+1).getSpotColor()) {
						if(_board.getSpotAt(i, j).getSpotColor() == _board.getSpotAt(i, j+2).getSpotColor()) {
							if(_board.getSpotAt(i, j).getSpotColor() == _board.getSpotAt(i, j+3).getSpotColor()) {
								
								_game_won = true;
								for(Spot spot:_board) {
									spot.unhighlightSpot();
								} 
								
								_board.getSpotAt(i, j).highlightSpot();
								_board.getSpotAt(i, j+1).highlightSpot();
								_board.getSpotAt(i, j+2).highlightSpot();
								_board.getSpotAt(i, j+3).highlightSpot();
								_message.setText(player_name + " wins!");
							}
						}
					}
				}
			}
		}
		
		
		

		// Diagonal that looks like /
		/* Adds 1 to every x value but subtracts 1 from every y value so compare (x,y) to (x+1, y-1)
		 * then (x+2, y-2), etc. until there is 4 matching.
		 * i starts at 3 because on a board, near the corners, you cannot make 4 matching spots because 
		 * there aren't enough spots diagonally.
		 * j = y axis. i = x axis. 
		 */

//		for(int j=0; _game_won == false && j<5;j++) {
//			for(int i=0; _game_won == false && i<6; i++) { 
//				if(!_board.getSpotAt(j, i).isEmpty()) {
//					if(_board.getSpotAt(j, i).getSpotColor() == _board.getSpotAt(j+1, i-1).getSpotColor()) {
//						if(_board.getSpotAt(j, i).getSpotColor() == _board.getSpotAt(j+2, i-2).getSpotColor()) {
//							if(_board.getSpotAt(j, i).getSpotColor() == _board.getSpotAt(j+3, i-3).getSpotColor()) {
//								_game_won = true;
//								_message.setText(player_name + " wins!");
//								
//							}
//						}
//					}
//				}
//			}
//		}
		
		
		for(int i=6; !_game_won&& i>2; i--) {
			for(int j=0; !_game_won && j<3; j++) {
				if(!_board.getSpotAt(i, j).isEmpty()) {
					if(_board.getSpotAt(i, j).getSpotColor() == _board.getSpotAt(i-1, j+1).getSpotColor()) {
						if(_board.getSpotAt(i, j).getSpotColor() == _board.getSpotAt(i-2, j+2).getSpotColor()) {
							if(_board.getSpotAt(i, j).getSpotColor() == _board.getSpotAt(i-3, j+3).getSpotColor()) {
								
								_game_won = true;
								for(Spot spot:_board) {
									spot.unhighlightSpot();
								} 
								// this makes sure that the winning column is not highlighted at the end.
								
								_board.getSpotAt(i, j).highlightSpot();
								_board.getSpotAt(i-1, j+1).highlightSpot();
								_board.getSpotAt(i-2, j+2).highlightSpot();
								_board.getSpotAt(i-3, j+3).highlightSpot();
								_message.setText(player_name + " wins!");
							}
						}
					}
				}
			}
		}
		

		// Diagonal that looks like \
		for(int j=0; _game_won == false && j<4;j++) {
			for(int i=0; _game_won == false && i<3; i++) {
				if(!_board.getSpotAt(j, i).isEmpty()) {
					if(_board.getSpotAt(j, i).getSpotColor() == _board.getSpotAt(j+1, i+1).getSpotColor()) {
						if(_board.getSpotAt(j, i).getSpotColor() == _board.getSpotAt(j+2, i+2).getSpotColor()) {
							if(_board.getSpotAt(j, i).getSpotColor() == _board.getSpotAt(j+3, i+3).getSpotColor()) {

								_game_won = true;
								for(Spot spot:_board) {
									spot.unhighlightSpot();
								} 
								
								_board.getSpotAt(j+1, i+1).highlightSpot();
								_board.getSpotAt(j+2, i+2).highlightSpot();
								_board.getSpotAt(j+3, i+3).highlightSpot();
								_board.getSpotAt(j, i).highlightSpot();
								_message.setText(player_name + " wins!");
							}
						}
					}
				}
			}
		}



		// draw

		int full = 0;
		for(Spot fullBoard: _board) {
			if(!fullBoard.isEmpty()) {
				full = full + 1;
			}
		}
		if(full == 42) {
			if(_game_won == false) {
				_message.setText("It is a draw.");
			}
		}


		/* Set color of spot clicked and toggle. */


		/* Check if spot clicked is secret spot.
		 * If so, mark game as won and update background
		 * of spot to show that it was the secret spot.
		 */

//		_game_won = (s == _secret_spot);
//		if (_game_won) {
//			s.setBackground(Color.LIGHT_GRAY);
//		}

		/* Update the message depending on what happened.
		 * If spot is empty, then we must have just cleared the spot. Update message accordingly.
		 * If spot is not empty and the game is won, we must have
		 * just won. Calculate score and display as part of game won message.
		 * If spot is not empty and the game is not won, update message to
		 * report spot coordinates and indicate whose turn is next.
		 */
		//
		//		if (s.isEmpty()) {
		//			_message.setText(player_name + " cleared the spot at " + s.getCoordString() + ". " + next_player_name + " to play.");
		//		} else {
		//			if (_game_won)  {
		//				int score = _board.getSpotWidth() * _board.getSpotHeight();
		//				for (Spot board_spot : _board) {
		//					if (!board_spot.isEmpty()) {
		//						if (board_spot.getSpotColor() == player_color) {
		//							score -= 1;
		//						} else {
		//							score += 1;
		//						}
		//					}
		//				}
		//				_message.setText(player_name + " found the secret spot at " + s.getCoordString() + ". " +
		//						"Score: " + score + ". Game over.");
		//			} else {
		//				_message.setText("Spot at " + s.getCoordString() + " is not the spot. Better luck next time. " + next_player_name + " to play.");
		//			}
		//		} 
		//	}
	}



 

	@Override
	public void spotEntered(Spot s) {
		/* Highlight spot if game still going on. */
		int col = s.getSpotX();
		if (_game_won) {
			return;
		}

		for(int j=5; j>=0; j--) {
			if(_board.getSpotAt(col,  j).isEmpty()) {
				_board.getSpotAt(col, j).highlightSpot();
			} else {
				_board.getSpotAt(col,  j).unhighlightSpot();
			}
		}

	}

	@Override
	public void spotExited(Spot s) {
		/* Unhighlight spot. */

		int col = s.getSpotX();
		for(int j=5; j>=0; j--) {
			if(!_game_won) {
				_board.getSpotAt(col,  j).unhighlightSpot();
			}
		}
	}
	

}
