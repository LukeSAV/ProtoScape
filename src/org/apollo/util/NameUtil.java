package org.apollo.util;

/**
 * A class which contains name-related utility methods.
 * @author Graham
 */
public final class NameUtil {

	/**
	 * An array of valid characters in a player name encoded as a long.
	 */
	private static final char[] NAME_CHARS = {
		'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
		'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
		'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '@',
		'#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '=', ':', ';',
		'.', '>', '<', ',', '"', '[', ']', '|', '?', '/', '`'
	};

	/**
	 * Converts a player name to a long.
	 * @param name The player name.
	 * @return The long.
	 */
	public static long encodeBase37(String name) {
		if (name.length() > 12) {
			throw new IllegalArgumentException("name too long");
		}
		long l = 0L;
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			l *= 37L;
			if (c >= 'A' && c <= 'Z') {
				l += (1 + c) - 65;
			} else if (c >= 'a' && c <= 'z') {
				l += (1 + c) - 97;
			} else if (c >= '0' && c <= '9') {
				l += (27 + c) - 48;
			}
		}
		for (; l % 37L == 0L && l != 0L; l /= 37L);
		return l;
	}

	/**
	 * Converts a long to a player name.
	 * @param l The long.
	 * @return The player name.
	 */
	public static String decodeBase37(long l) {
		int i = 0;
		char[] chars = new char[12];
		while (l != 0L) {
			long tmp = l;
			l /= 37L;
			chars[11 - i++] = NAME_CHARS[(int) (tmp - l * 37L)];
		}
		return new String(chars, 12 - i, i);
	}

	/**
	 * Default private constructor to prevent instantiation.
	 */
	private NameUtil() {

	}
        
        /**
	 * Converts a name to a long.
	 * @param s The name.
	 * @return The long.
	 */
	public static long nameToLong(String s) {
		long l = 0L;
		for(int i = 0; i < s.length() && i < 12; i++) {
			char c = s.charAt(i);
			l *= 37L;
			if(c >= 'A' && c <= 'Z') l += (1 + c) - 65;
			else if(c >= 'a' && c <= 'z') l += (1 + c) - 97;
			else if(c >= '0' && c <= '9') l += (27 + c) - 48;
		}
		while(l % 37L == 0L && l != 0L) l /= 37L;
		return l;
	}
	
	/**
	 * Converts a long to a name.
	 * @param l The long.
	 * @return The name.
	 */
	public static String longToName(long l) {
		int i = 0;
		char ac[] = new char[12];
		while (l != 0L) {
			long l1 = l;
			l /= 37L;
			ac[11 - i++] = NAME_CHARS[(int) (l1 - l * 37L)];
		}
		return new String(ac, 12 - i, i);
	}

	/**
	 * Formats a name for display.
	 * @param s The name.
	 * @return The formatted name.
	 */
	public static String formatName(String s) {
		return fixName(longToName(nameToLong(s.replace(" ", "_"))));
	}
	
	/**
	 * Method that fixes capitalization in a name.
	 * @param s The name.
	 * @return The formatted name.
	 */
	private static String fixName(final String s) {
		if(s.length() > 0) {
			final char ac[] = s.toCharArray();
			for(int j = 0; j < ac.length; j++)
				if(ac[j] == '_') {
					ac[j] = ' ';
					if((j + 1 < ac.length) && (ac[j + 1] >= 'a')
							&& (ac[j + 1] <= 'z')) {
						ac[j + 1] = (char) ((ac[j + 1] + 65) - 97);
					}
				}

			if((ac[0] >= 'a') && (ac[0] <= 'z')) {
				ac[0] = (char) ((ac[0] + 65) - 97);
			}
			return new String(ac);
		} else {
			return s;
		}
	}

}
