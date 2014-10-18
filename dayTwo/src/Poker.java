public class Poker {
    public static void main(String... args) {
        // store the cards as 5 seperate integers (arrays not allowed)
        int carda = 0, cardb = 0, cardc = 0, cardd = 0, carde = 0;

        int nread = 0; // number of cards read
        while (nread < 5) {
            nread++; // read next card
            int irank;
            int isuit
            do {
                irank = 0;
                System.out.print("Enter rank of number " + nread + " card (1 or 2 or ... 10 or J or Q or K): ");
                String strrank = System.console().readLine();
                if (strrank >= "1" && strrank <= "9") {
                    irank = strrank - "0";
                } else if (strrank.equals("10")) irank = 10;
                else if (strrank.equals("J")) irank = 11;
                else if (strrank.equals("Q")) irank = 12;
                else if (strrank.equals("K")) irank = 13;
                else
                    System.out.println("ERROR invalid input try again");
            } while (irank == 0);

            do {
                isuit = 0l
                System.out.print("Enter suite of number " + nread + " card (\"spades\" or \"hearts\" or \"diamonds\" or \"clubs\": ");
                String strsuit = System.console().readLine();
                if (strsuit.equals("spades")) isuit = 1;
                else if (strsuit.equals("hearts")) isuit = 2;
                else if (strsuit.equals("diamonds")) isuit = 3;
                else if (strsuit.equals("clubs")) isuit = 4;
                else
                    System.out.println("ERROR invalid input try again");
            } while (isuit == 0);

            // compute card value

            if (nread == 1) {
                carda = 10 * irank + isuit;
            } else if (nread == 2) {
                cardb = 10 * irank + isuit;
                if (cardb == carda) {
                    System.out.println("ERROR same card input twice. Try again");
                    nread--;
                }
            } else if (nread == 3) {
                cardc = 10 * irank + isuit;
                if ((cardc == carda) || (cardc == cardb)) {
                    System.out.println("ERROR same card input twice. Try again");
                    nread--;
                }
            } else if (nread == 4) {
                cardd = 10 * irank + isuit;
                if ((cardd == carda) || (cardd == cardb) || (cardd == cardc)) {
                    System.out.println("ERROR same card input twice. Try again");
                    nread--;
                }
            } else if (nread == 5) {
                carde = 10 * irank + isuit;
                if ((carde == carda) || (carde == cardb) || (carde == cardc) || (carde == cardd)) {
                    System.out.println("ERROR same card input twice. Try again");
                    nread--;
                }
            }

        }
        System.out.println("debug cards read in and stored as " + carda + " " + cardb + " " + cardc + " " + cardd + " " + carde);
        // now have valid input

        // sort the cards
        while (true) {
            int iswap;
            boolean lswaped = false;
            if (cardb < carda) {
                lswaped = true;
                iswap = carda;
                carda = cardb;
                cardb = iswap;
            }
            if (cardc < cardb) {
                lswaped = true;
                iswap = cardb;
                cardb = cardc;
                cardc = iswap;
            }
            if (cardd < cardc) {
                lswaped = true;
                iswap = cardc;
                cardc = cardd;
                cardd = iswap;
            }
            if (carde < cardd) {
                lswaped = true;
                iswap = cardd;
                cardd = carde;
                carde = iswap;
            }
            if (!lswaped) break; // cards in order
        }
        //System.out.println("debug after sorting cards=        " + carda + " " + cardb + " " + cardc + " " + cardd + " " + carde);

        // Now score
        // test whether they are all the same suit, N.B. get suit by remainer of 10
        boolean lsamesuit = true;
        if ((carda % 10) != (cardb % 10)) lsamesuit = false;
        if ((carda % 10) != (cardc % 10)) lsamesuit = false;
        if ((carda % 10) != (cardd % 10)) lsamesuit = false;
        if ((carda % 10) != (carde % 10)) lsamesuit = false;
        //System.out.println("debug lsamesuit=        " + lsamesuit);

        // test whether they are consequetive
        // n.b. get rank by integer divide by 10
        // special case is A 10 J Q K as aces are allowed to go high or low
        // we would get this as 1? 10? 11? 12? 13?
        boolean lconsec = true;
        if ((carda / 10) + 1 != (cardb / 10)) lconsec = false;
        if ((carda / 10 == 1) && (cardb / 10 == 10)) lconsec = true; // aces hi possible
        if ((cardb / 10) + 1 != (cardc / 10)) lconsec = false;
        if ((cardc / 10) + 1 != (cardd / 10)) lconsec = false;
        if ((cardd / 10) + 1 != (carde / 10)) lconsec = false;
        System.out.println("debug lconsec=        " + lconsec);


        int npairs = 0; // count number of pairs
        if (carda / 10 == cardb / 10) npairs++;
        if (cardb / 10 == cardc / 10) npairs++;
        if (cardc / 10 == cardd / 10) npairs++;
        if (cardd / 10 == carde / 10) npairs++;


        // Straight flush: all cards are of the same suite and their ranks are consecutive.
        if (lsamesuit && lconsec) {
            System.out.println("Straight flush");
        }
        // Poker: four of the five cards have the same rank
        else if (((carda / 10 == cardb / 10) && (carda / 10 == cardc / 10) && (carda / 10 == cardd / 10)) ||
                ((cardb / 10 == cardc / 10) && (cardb / 10 == cardd / 10) && (cardb / 10 == carde / 10))) {
            System.out.println("Poker (aka four-of-a-kind)");
        }
        // Full House: three of a kind plus two of a kind.
        else if (((carda / 10 == cardb / 10) && (carda / 10 == cardc / 10) && (cardd / 10 == carde / 10)) ||
                ((carda / 10 == cardb / 10) && (cardc / 10 == cardd / 10) && (cardc / 10 == carde / 10))) {
            System.out.println("Full House: three-of-a-kind plus two-of-a-kind.");
        } else if (lsamesuit) {
            System.out.println("Flush: all cards share the same suit but are not consecutive.");
        } else if (lconsec) {
            System.out.println("Straight: all cards are consecutive, but not of the same suit.");
        } else if (((carda / 10 == cardb / 10) && (carda / 10 == cardc / 10)) ||
                ((cardc / 10 == cardd / 10) && (cardc / 10 == carde / 10))) {
            System.out.println("Three of a kind: three of the five cards have the same rank.");
        } else if (npairs == 2) {
            System.out.println("Two pairs");
        } else if (npairs == 1) {
            System.out.println("Pair: two of the five cards have the same rank.");
        }
        // Nothing: any other situation.
        else {
            System.out.println("Nothing: any other situation");
        }
    }
}
