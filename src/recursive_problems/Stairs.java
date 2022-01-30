package recursive_problems;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Stairs {

    public static int maxStamina(int[] stair, int stamina) throws InsufficientStaminaException {
        Set<String> allMoves = generateRoutes(stair.length, -1, "0", new HashSet<String>());
        int maxStamina = 0;
        int tempStaminaValue;

        System.out.println("------------------------------------");
        for (String moves : allMoves) {
            tempStaminaValue = staminaRemaining(stair, stamina, moves);
            if (tempStaminaValue == 5) {
                System.out.println(moves);
                System.out.println(tempStaminaValue);
                System.out.println("------------------------------------");
            }
            if (tempStaminaValue > maxStamina) {
                maxStamina = tempStaminaValue;
            }
        }

        if (maxStamina <= 0) {
            throw new InsufficientStaminaException("Not enough stamina, you'll need to exercise more!");
        }

        return maxStamina;
    }

    private static int staminaRemaining(int[] stair, int initialStamina, String moves) {
        int staminaRemaining = initialStamina;
        int position = -1;
        for (int moveIndex = 0; moveIndex < moves.length(); moveIndex++) {
            int move = (moves.charAt(moveIndex) - 48);

            // First, take into account the stamina drain of the move itself.
            if (move == 2) {
                staminaRemaining -= 1;
            }
            else if (move == 3) {
                staminaRemaining -= 2;
            }

            // Next, increment the position.
            position += move;

            // Check if we have cleared the stairs:
            if (position >= stair.length) {
                return staminaRemaining;
            }

            // If we haven't cleared the stairs, we're still here. So finally, take away the stamina
            // at the specific stair we are now on.
            staminaRemaining -= stair[position];
        }
        return staminaRemaining;
    }

    private static Set<String> generateRoutes(int n, int position, String pastMove, Set<String> moves) {
        if (position >= n) {
            Set<String> newMoves = new HashSet<>();
            for (String actions : moves) {
                newMoves.add(actions + pastMove);
            }
            return newMoves;
        }
        else if (Objects.equals(pastMove, "0")) {
            Set<String> allMoves = new HashSet<>();

            moves.add("");

            Set<String> set1 = generateRoutes(n, position + 1, "1", moves);
            Set<String> set2 = generateRoutes(n, position + 2, "2", moves);
            Set<String> set3 = generateRoutes(n, position + 3, "3", moves);

            allMoves.addAll(set1);
            allMoves.addAll(set2);
            allMoves.addAll(set3);

            return allMoves;
        }

        Set<String> newMoves = new HashSet<>();
        Set<String> allMoves = new HashSet<>();

        for (String actions : moves) {
            newMoves.add(actions + pastMove);
        }

        Set<String> set1 = generateRoutes(n, position + 1, "1", newMoves);
        Set<String> set2 = generateRoutes(n, position + 2, "2", newMoves);
        Set<String> set3 = generateRoutes(n, position + 3, "3", newMoves);

        allMoves.addAll(set1);
        allMoves.addAll(set2);
        allMoves.addAll(set3);

        return allMoves;
    }
}
