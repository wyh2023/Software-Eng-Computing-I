import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompareNumbersTest {

	InputStream in = null;
	PrintStream out = null;

	InputStream inputStream = null;
	OutputStream outputStream = null;

	@Before
	public void setUp() {
		in = System.in;
		out = System.out;

		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

	}

	@After
	public void tearDown() {
		System.setIn(in);
		System.setOut(out);
	}

	@Test
	public void test1() {
		check(51, 51, 17, "There are same numbers.");
	}

	@Test
	public void test2() {
		check(-124, -96, -99, "The largest number is -96.");
	}

	@Test
	public void test3() {
		check(1, 1, 1, "There are same numbers.");
	}

	@Test
	public void test4() {
		check(-1, 9, 17, "The largest number is 17.");
	}

	@Test
	public void test5() {
		check(12, -9, -9, "There are same numbers.");
	}

	@Test
	public void test6() {
		check(12, 33, 32, "The largest number is 33.");
	}

	@Test
	public void test7() {
		check(0, 0, 17, "There are same numbers.");
	}

	@Test
	public void test8() {
		check(51, 56, 52, "The largest number is 56.");
	}

	@Test
	public void test9() {
		check(51, 17, 17, "There are same numbers.");
	}

	@Test
	public void test10() {
		check(51, 96, 17, "The largest number is 96.");
	}

	private void check(int a, int b, int c, String expected) {

		String input = a + System.lineSeparator() + b + System.lineSeparator() + c;
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);

		CompareNumbers.main(null);
		
		String actual = outputStream.toString().split(System.lineSeparator())[3];
		assertEquals(expected, actual);

	}

}
