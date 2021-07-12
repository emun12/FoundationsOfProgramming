package a7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class OthelloWidget extends JPanel implements ActionListener, SpotListener {
	private enum Player {BLACK, WHITE};

	private JSpotBoard _board;		/* SpotBoard playing area. */
	private JLabel _message;		/* Label for messages. */
	private boolean _game_won;		/* Indicates if games was been won already.*/
	private Spot _secret_spot;		/* Secret spot which wins the game. */
	private Color _secret_spot_bg;  /* Needed to reset the background of the secret spot. */
	private Player _next_to_play;	/* Identifies who has next turn. */

	public OthelloWidget() { 

		/* Create SpotBoard and message label. */

		_board = new JSpotBoard(8,8);

		_message = new JLabel();

		for(Spot s: _board) {
			if(s.getSpotX() % 2 == 0 && s.getSpotX() %2 == 0) {
				if(s.getSpotY() %2 == 0 || s.getSpotY() == 0) {
					s.setBackground(Color.LIGHT_GRAY);
				} else {
					s.setBackground(Color.DARK_GRAY);
				}
			} 
			else if (s.getSpotX() % 2 !=0 || s.getSpotX() != 0) {
				if(s.getSpotY() %2 == 0 || s.getSpotY() == 0) {
					s.setBackground(Color.DARK_GRAY);
				} else {
					s.setBackground(Color.LIGHT_GRAY);
				}
			}
			// for the uneven columns, the background will be dark gray.
			// for the even columns, the background will be light gray.
		}



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


		for (Spot s : _board) {
			s.setSpotColor(Color.LIGHT_GRAY);
			//	s.unhighlightSpot();
			s.clearSpot();


		}


		_board.getSpotAt(3, 3).setSpotColor(Color.WHITE);
		_board.getSpotAt(3, 3).toggleSpot();


		_board.getSpotAt(3, 4).setSpotColor(Color.BLACK);
		_board.getSpotAt(3, 4).toggleSpot();


		_board.getSpotAt(4, 4).setSpotColor(Color.WHITE);
		_board.getSpotAt(4, 4).toggleSpot();

		_board.getSpotAt(4, 3).setSpotColor(Color.BLACK);
		_board.getSpotAt(4, 3).toggleSpot();




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
//
		/* Reset game won and next to play fields */
		_game_won = false;
		_next_to_play = Player.BLACK;		

		/* Display game start message. */

		_message.setText("Welcome to Othello. Black to play");
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

		if (_next_to_play == Player.BLACK) {
			player_color = Color.BLACK;
			player_name = "Black";
			next_player_name = "White";
			_next_to_play = Player.WHITE;
		} else {
			player_color = Color.WHITE;
			player_name = "White";
			next_player_name = "Black";
			_next_to_play = Player.BLACK;			
		}



		/* Set color of spot clicked and toggle. */
				s.setSpotColor(player_color);
				s.toggleSpot();



		/* Update the message depending on what happened.
		 * If spot is empty, then we must have just cleared the spot. Update message accordingly.
		 * If spot is not empty and the game is won, we must have
		 * just won. Calculate score and display as part of game won message.
		 * If spot is not empty and the game is not won, update message to
		 * report spot coordinates and indicate whose turn is next.
		 */


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
		//				                 "Score: " + score + ". Game over.");
		//			} else {
		//				_message.setText("Spot at " + s.getCoordString() + " is not the spot. Better luck next time. " + next_player_name + " to play.");
		//			}
		//		}
				
				_message.setText(next_player_name+ " to play.");
				
				
				
				int count=0;
				for(Spot spot: _board) {
					if(spot.isEmpty() == false) {
						count = count + 1;
					}
				}
				if(count == 42) {
					if(_game_won == false) {
						_message.setText("It is a draw.");
					}
				}
				
				
				
	}

	public boolean isValid (Spot spot) {
		int x = spot.getSpotX();
		int y = spot.getSpotY();
		int difference = 0;
		int bigX = 0;
		int littleY = 0;
		int littleX = 0;
		int bigY = 0;
		boolean discs_between = false;
		
		
		Color player = spot.getSpotColor();
		// player_color = null;
		
		if(_next_to_play == Player.BLACK) {
			player = Color.BLACK;
		} else {
			player = Color.WHITE;
		}
		
		for(Spot spots: _board) {
			// this checks horizontal 
			if(spots.getSpotX() == x && spots.getSpotColor() == player) {
				// if the x coordinates are the same so it is on the same row and it has
				// same color disc
				if(spots.getSpotY() - y > 1) {
					difference = spots.getSpotY() - 1;
					discs_between = true;
					// if the y coordinates are different, then there are discs inbetween
					
					for(int i = difference; i > y; i--) {
						if(_board.getSpotAt(x, i).getSpotColor() == player||_board.getSpotAt(x, i).isEmpty()) {
							discs_between = false;
							// if the discs in between are the same color, then it is not valid.
						}
					}
					if(discs_between == true) {
						spots.clearSpot();
						player = spots.getSpotColor();
						spots.setSpotColor(player);
						spots.toggleSpot();
						return true;
						// if it passed through the for loop, then that means the
						// spot in between is valid.
					}
					
				} else if (y-spots.getSpotY() > 1) {
					// checks the same things as the first if statement but
					// checks it in reverse order.
					difference = y-1;
					discs_between = true;
					for(int i=difference; i>spots.getSpotY(); i--) {
						if(_board.getSpotAt(x, i).getSpotColor() == player||_board.getSpotAt(x, i).isEmpty()) {
							discs_between = false;
						}
					}
					if(discs_between == true) {
						spots.clearSpot();
						player = spots.getSpotColor();
						spots.setSpotColor(player);
						spots.toggleSpot();
						return true;
					}
				}
			}
			
			//this checks vertical
			if(spots.getSpotY() == y && spots.getSpotColor() == player) {
				// if the y coordinates are the same, there could be discs of the 
				// same color on the same column.
				if(spots.getSpotX() - x>1) {
					difference = spots.getSpotX() -1;
					discs_between = true;
					for(int i=difference; i > x; i--) {
						if(_board.getSpotAt(i, y).getSpotColor() == player||_board.getSpotAt(i, y).isEmpty()) {
							discs_between = false;
						}
					}
					if(discs_between == true) {
						spots.clearSpot();
						player = spots.getSpotColor();
						spots.setSpotColor(player);
						spots.toggleSpot();
						return true;
					}
				} else if(x-spots.getSpotX() > 1) {
					difference = x-1;
					discs_between = true;
					
					for(int i=difference; i > spots.getSpotX(); i--) {
						if(_board.getSpotAt(i, y).getSpotColor() == player||_board.getSpotAt(i, y).isEmpty()) {
							discs_between = false;
						}
					}
					if(discs_between == true) {
						spots.clearSpot();
						player = spots.getSpotColor();
						spots.setSpotColor(player);
						spots.toggleSpot();
						return true;
					}
					
				}
			}
		
		
			
		//diagonal /
			
		// (x+1, y-1) upper right diagonal
//			if(Math.abs(spots.getSpotX() - x) == Math.abs(spots.getSpotY() - y)) {
//				// if they have the same difference
//				if(spots.getSpotX() > x) {
//					bigX = spots.getSpotX();
//					littleX = x;
//					 
//				} else {
//					bigX = x;
//					littleX = spots.getSpotX();
//				}
//				if(spots.getSpotY() > y) {
//					bigY = spots.getSpotY();
//					littleY = y;
//					
//				} else { 
//					bigY = y;
//					littleY = spots.getSpotY();
//				}
//				difference = bigX - littleX;
//				
//				discs_between = true;
//				
//				for(int i=littleX; i>0; i++) {
//					for(int j=bigY; j>0; j--) {
//						if(_board.getSpotAt(i, j).getSpotColor() == _board.getSpotAt(i+1,j-1).getSpotColor() ) {
//							discs_between = false;
//							
//						} else {
//							discs_between = true;
//						}
//						
//						
//					}
//					
//				}
//			
//			}
			
			
			
//			if(Math.abs(spots.getSpotX() - x) == Math.abs(spots.getSpotY() - y)) {
//				// if they have the same difference
//				if(spots.getSpotX() > x) {
//					bigX = spots.getSpotX();
//					littleX = x;
//					 
//				} else {
//					bigX = x;
//					littleX = spots.getSpotX();
//				}
//				if(spots.getSpotY() > y) {
//					bigY = spots.getSpotY();
//					littleY = y;
//					
//				} else {
//					bigY = y;
//					littleY = spots.getSpotY();
//				}
//				
//				discs_between = true;
//				
//				for(int i=littleX+1; i<bigX; i++) {
//					for(int j=bigY-1; j>littleY;j--) {
//						if(_board.getSpotAt(i, j).getSpotColor() == player ||_board.getSpotAt(i, j).isEmpty()) {
//							discs_between = false;
//						}
//					}
//					if(discs_between == true) {
//						return true;
//					}
//				}
//				for(int i=bigX-1; i>littleX; i--) {
//					for(int j=littleY+1; j<bigY; j++) {
//						if(_board.getSpotAt(i, j).getSpotColor() == player ||_board.getSpotAt(i, j).isEmpty()){
//							discs_between = false;
//						}
//					}
//					if(discs_between == true) {
//						return true;
//					}
//				}
//			}
//			
			
			
			// for diagonal that looks like \, logic should be 
			// (x-1, y+1)
			//for diagonal that looks like /, logic should be
			// (x+1, y-1)
			
		}
		
		
		return false;
		

	}
	
	
	public void flip_discs(Spot spots, Color player_color) {
//		Color player = spots.getSpotColor();
//		for(Spot spot: _board) {
//			if(isValid(spots) == true ) {
//				spots.clearSpot();
//				spots.setSpotColor(player_color);
////				spots.toggleSpot();
//			}
//		}
		
		
	}




	@Override
	public void spotEntered(Spot s) {
		/* Highlight spot if game still going on. */

		if (_game_won) {
			return;
		}
		if(s.isEmpty() && isValid(s)) {
			s.highlightSpot();
		}
	
	}

	@Override
	public void spotExited(Spot s) {
		/* Unhighlight spot. */

		s.unhighlightSpot();
	}


}
