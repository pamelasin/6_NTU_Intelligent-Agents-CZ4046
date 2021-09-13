class sin_pamela_Player extends Player {
	int selectAction(int n, int[] myHistory, int[] oppHistory1, int[] oppHistory2) {
		if (n == 0)
			return 0; // cooperate on first round (n = 0)


		if (n % 2 != 0) // for odd rounds (n = 1, 3, ..., 99), count defects and cooperates of the two opponent
		{
			int count_enemy_coop = 0;
			int count_enemy_def = 0;

			for (int i = 0; i < n; i++) {
				if (oppHistory1[i] == 1) 
				{
					count_enemy_def = count_enemy_def + 1; // count the past history of defects of opponent 1
				}
				else {
					count_enemy_coop = count_enemy_coop + 1; // count the past history of cooperates of opponent 1
					
				}


				if (oppHistory2[i] == 1) {
					count_enemy_def = count_enemy_def + 1; // count the past history of defects of opponent 2
				}
				else {
					count_enemy_coop = count_enemy_coop + 1; // count the past history of cooperates of opponent 2
				}
			}
			
			if(count_enemy_def > count_enemy_coop) {
				return 1; // if the number of defects of opponents in history is more than cooperates, action is to defect
			}
			else {
				return 0; // if the number of cooperates of opponents in history is more than defects, action is to cooperate
			}
		}
		
		if (oppHistory1[n-1] == oppHistory2[n-1]) { // for even rounds (n = 2, 4, ..., 100) if the past history (n - 1) of both opponents is the same, action performed now is the same
			return oppHistory1[n-1];
		}
		else { 
			return 1; // for even rounds (n = 2, 4, ..., 100) if the past history (n - 1) of both opponents is different, action performed now is to defect 
		}
		
	
	}

}
