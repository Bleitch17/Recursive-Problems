package recursive_problems;

import java.util.*;

public class SSDNumbers {

    /**
     * Obtain the largest SSDNumber (as a String) with {@code numDigits} digits that
     * contains the digit {@code mustContainDigit}.
     * @param numDigits the number of digits in the SSDNumber, {@code numDigits} > 0
     * @param mustContainDigit a digit that must be present in the number being generated, 0 <  {@code mustContainDigit} < 10
     * @return the largest SSDNumber (as a String) with {@code numDigits} digits
     *          that contains the digit {@code mustContainDigit}
     * @throws NoSuchElementException if no such SSDNumber exists
     */
    public static String getLargestSSDNumber(int numDigits, int mustContainDigit) throws NoSuchElementException {
        List<Integer> digits = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        Set<Integer> ssdComponents = findDigits(digits, mustContainDigit, numDigits);

        int sum = 0;
        for (int i : ssdComponents) {
            sum += i;
        }
        if (sum == numDigits) {
            String ssd = buildSSD(ssdComponents);
            return ssd;
        }
        else {
            throw new NoSuchElementException("No such element");
        }
    }

    private static String buildSSD(Set<Integer> components) {
        if (components.size() <= 1) {
            String ssd = "";
            List<Integer> component = new ArrayList<>(components);
            for (int iterations = 0; iterations < component.get(0); iterations++) {
                ssd += String.valueOf(component.get(0));
            }
            return ssd;
        }
        else {
            int currentComponent = findBiggest(new ArrayList<Integer>(components));
            String ssd = "";
            for (int iterations = 0; iterations < currentComponent; iterations++) {
                ssd += String.valueOf(currentComponent);
            }
            components.remove(currentComponent);
            return ssd + buildSSD(components);
        }
    }

    private static Set<Integer> findDigits(List<Integer> digitsLeft, int digit, int length) {
        if (findNextBiggestNumber(digitsLeft, digit) <= 0) {
            return new HashSet<>();
        }
        else {
            Set<Integer> digits = new HashSet<>();
            int newDigit = findNextBiggestNumber(digitsLeft, digit);
            int lengthRemaining = length - newDigit;
            digitsLeft.remove(digitsLeft.indexOf(newDigit));
            digits.add(newDigit);

            digits.addAll(findDigits(digitsLeft, findNextBiggestNumber(digitsLeft, lengthRemaining), lengthRemaining));
            return digits;
        }
    }

    private static int findNextBiggestNumber(List<Integer> numbers, int number) {
        int biggestNumber = 0;
        for (int i : numbers) {
            if (i <= number && i > biggestNumber) {
                biggestNumber = i;
            }
        }
        return biggestNumber;
    }

    private static int findBiggest(List<Integer> numbers) {
        int biggest = 0;
        for (int i : numbers) {
            if (i >= biggest) {
                biggest = i;
            }
        }
        return biggest;
    }
}
