package assignments.Ex1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


    public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }

        @Test
        void isNumberTest() {
            //Valid cases
            assertTrue (Ex1.isNumber("123bA"));
            assertTrue(Ex1.isNumber("101101b2"));
            assertTrue(Ex1.isNumber("1E2bF"));
            assertTrue(Ex1.isNumber("5"));
            assertTrue(Ex1.isNumber("0b4"));


            //Invalid cases
            assertFalse (Ex1.isNumber("b2"));//Invalid number part
            assertFalse (Ex1.isNumber("123b"));//Invalid base
            assertFalse(Ex1.isNumber(""));//Empty string
            assertFalse(Ex1.isNumber("35bb9"));//More than one 'b'


        }



        @Test
        void int2NumberTest() {
            //Valid cases
            assertEquals("0b2", Ex1.int2Number(0,2));
            assertEquals("D3bF", Ex1.int2Number(198, 15) );

            //Invalid cases
            assertEquals("", Ex1.int2Number(-1,2));//Number can't be negative
            assertEquals("", Ex1.int2Number(3,17));//Base is too large
            assertEquals("", Ex1.int2Number(5, 1));//Base too small
        }



        @Test
        void number2IntTest () {
            //Valid cases
            assertEquals(238, Ex1.number2Int("154bD"));
            assertEquals(0, Ex1.number2Int("0bA"));
            assertEquals(11, Ex1.number2Int("1011b2"));

            //Invalid cases
            assertEquals(-1, Ex1.number2Int("34bH"));//Invalid base
            assertEquals(-1, Ex1.number2Int("75b2"));//Number part not suitable for base
            assertEquals(-1, Ex1.number2Int("HbA"));//Invalid number part



        }



        @Test
        void equalsTest() {
            //Valid cases
            assertTrue(Ex1.equals("1011b2", "11bA"));
            assertTrue(Ex1.equals("0b2", "0bA"));
            assertTrue(Ex1.equals("D3bF", "198bA"));

            //Invalid cases
            assertFalse(Ex1.equals("14bD", "D5bF"));
            assertFalse(Ex1.equals("12b", "53"));
        }




        @Test
        void maxIndexTest() {
            String [] arr = {"23b8", "AAbF", "126", "864bC"};
            assertEquals(3, Ex1.maxIndex(arr));



        }

    }

