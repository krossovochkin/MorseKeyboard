/* 
** Copyright 2012 Google Inc. All Rights Reserved.
** 
** Licensed under the Apache License, Version 2.0 (the "License");
** you may not use this file except in compliance with the License.
** You may obtain a copy of the License at
** 
**   http://www.apache.org/licenses/LICENSE-2.0
** 
** Unless required by applicable law or agreed to in writing, software
** distributed under the License is distributed on an "AS IS" BASIS,
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
** See the License for the specific language governing permissions and
** limitations under the License.
*/

package com.rgam.morsekeyboard;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Reed Morse
 *
 * @author Vasya Drobushkov changed:
 * - added Russian translation table
 * - HashMap<Integer, Character> replaced by SparseArray
 * // TODO add commas, dots etc.
 */
public class Morse {
	private static final SparseArray<Character> translationTableEnglish;
    private static final SparseArray<Character>  translationTableRussian;

    public enum Language {
        LANGUAGE_ENGLISH,
        LANGUAGE_RUSSIAN
    }

    public class Letter {

        private char lCase;
        private char uCase;

        public Letter(char lCase, char uCase) {
            this.lCase = lCase;
            this.uCase = uCase;
        }

        public char getlCase() {
            return lCase;
        }

        public char getuCase() {
            return uCase;
        }
    }

    private static Language mCurrentLanguage = Language.LANGUAGE_RUSSIAN; // TODO: set to default (previously used)

	// For translating Strings.
	public static final char DOT_CHAR = '.';
	public static final char DASH_CHAR = '-';

	public enum Code {
		DOT, DASH
	}

	static {
		translationTableEnglish = new SparseArray<Character>();

		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DASH }), 'A');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DOT,  Code.DOT,  Code.DOT }), 'B');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DOT,  Code.DASH,  Code.DOT }), 'C');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DOT,  Code.DOT }),   'D');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT }), 'E');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DASH,  Code.DOT }), 'F');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH,  Code.DOT }), 'G');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DOT,  Code.DOT }), 'H');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT }), 'I');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DASH,  Code.DASH,  Code.DASH }), 'J');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DOT,  Code.DASH }), 'K');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DASH,  Code.DOT,  Code.DOT }), 'L');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH }), 'M');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DOT }), 'N');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH,  Code.DASH }), 'O');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DASH,  Code.DASH,  Code.DOT }), 'P');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH,  Code.DOT,  Code.DASH }), 'Q');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DASH,  Code.DOT }), 'R');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DOT }), 'S');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH }), 'T');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DASH }), 'U');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DOT,  Code.DASH }), 'V');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DASH,  Code.DASH }),   'W');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DOT,  Code.DOT,  Code.DASH }), 'X');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DOT,  Code.DASH,  Code.DASH }), 'Y');
        translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH,  Code.DOT,  Code.DOT }), 'Z');

		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DASH,  Code.DASH,  Code.DASH,  Code.DASH }), '1');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DASH,  Code.DASH,  Code.DASH }), '2');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DOT,  Code.DASH,  Code.DASH }), '3');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DOT,  Code.DOT,  Code.DASH }), '4');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DOT,  Code.DOT,  Code.DOT }), '5');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DOT,  Code.DOT,  Code.DOT,  Code.DOT }), '6');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH,  Code.DOT,  Code.DOT,  Code.DOT }), '7');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH,  Code.DASH,  Code.DOT,  Code.DOT }), '8');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH,  Code.DASH,  Code.DASH,  Code.DOT }), '9');
		translationTableEnglish.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH,  Code.DASH,  Code.DASH,  Code.DASH }), '0');

        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DOT, Code.DASH, Code.DOT, Code.DASH, Code.DOT, Code.DASH}), '.');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DASH, Code.DOT, Code.DOT, Code.DASH, Code.DASH}), ',');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DOT, Code.DOT, Code.DASH, Code.DASH, Code.DOT, Code.DOT}), '?');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DOT, Code.DASH, Code.DASH, Code.DASH, Code.DASH, Code.DOT}), '\'');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DASH, Code.DOT, Code.DASH, Code.DASH}), '!');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DOT, Code.DASH, Code.DOT}), '/');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DASH, Code.DASH, Code.DOT}), '(');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DASH, Code.DASH, Code.DOT, Code.DASH}), ')');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DOT, Code.DASH, Code.DOT, Code.DOT, Code.DOT}), '&');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DASH, Code.DASH, Code.DOT, Code.DOT, Code.DOT}), ':');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DASH, Code.DOT, Code.DASH, Code.DOT}), ':');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DOT, Code.DOT, Code.DASH}), '=');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DOT, Code.DASH, Code.DOT, Code.DASH, Code.DOT}), '+');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DOT, Code.DOT, Code.DOT, Code.DASH}), '-');
        translationTableEnglish.put(Arrays.hashCode(new Code[] { Code.DOT, Code.DOT, Code.DASH, Code.DASH, Code.DOT, Code.DASH}), '_');
        translationTableEnglish.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DASH, Code.DASH, Code.DOT, Code.DASH, Code.DOT}), '@');
	}

    static {
        translationTableRussian = new SparseArray<Character>();

        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DASH}), 'A');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DOT, Code.DOT, Code.DOT}), 'Б');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DASH, Code.DASH}), 'В');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DASH, Code.DOT}), 'Г');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DOT, Code.DOT}), 'Д');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT}), 'Е');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DOT, Code.DOT, Code.DASH}), 'Ж');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DASH, Code.DOT, Code.DOT}), 'З');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DOT}), 'И');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DASH, Code.DASH, Code.DASH}), 'Й');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DOT, Code.DASH}), 'К');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DASH, Code.DOT, Code.DOT}), 'Л');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DASH}), 'М');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DOT}), 'Н');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DASH, Code.DASH}), 'О');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DASH, Code.DASH, Code.DOT}), 'П');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DASH, Code.DOT}), 'Р');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DOT, Code.DOT}), 'С');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH}), 'Т');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DOT, Code.DASH}), 'У');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DOT, Code.DASH, Code.DOT}), 'Ф');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DOT, Code.DOT, Code.DOT}), 'Х');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DOT, Code.DASH, Code.DOT}), 'Ц');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DASH, Code.DASH, Code.DOT}), 'Ч');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DASH, Code.DASH, Code.DASH}), 'Ш');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DASH, Code.DOT, Code.DASH}), 'Щ');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DASH, Code.DOT, Code.DASH, Code.DASH}), 'Ъ');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DOT, Code.DASH, Code.DASH}), 'Ы');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DASH, Code.DOT, Code.DOT, Code.DASH}), 'Ь');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DOT, Code.DASH, Code.DOT, Code.DOT}), 'Э');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DOT, Code.DASH, Code.DASH}), 'Ю');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DASH, Code.DOT, Code.DASH}), 'Я');

        translationTableRussian.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DASH,  Code.DASH,  Code.DASH,  Code.DASH }), '1');
        translationTableRussian.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DASH,  Code.DASH,  Code.DASH }), '2');
        translationTableRussian.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DOT,  Code.DASH,  Code.DASH }), '3');
        translationTableRussian.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DOT,  Code.DOT,  Code.DASH }), '4');
        translationTableRussian.put(Arrays.hashCode(new Code[]{ Code.DOT,  Code.DOT,  Code.DOT,  Code.DOT,  Code.DOT }), '5');
        translationTableRussian.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DOT,  Code.DOT,  Code.DOT,  Code.DOT }), '6');
        translationTableRussian.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH,  Code.DOT,  Code.DOT,  Code.DOT }), '7');
        translationTableRussian.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH,  Code.DASH,  Code.DOT,  Code.DOT }), '8');
        translationTableRussian.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH,  Code.DASH,  Code.DASH,  Code.DOT }), '9');
        translationTableRussian.put(Arrays.hashCode(new Code[]{ Code.DASH,  Code.DASH,  Code.DASH,  Code.DASH,  Code.DASH }), '0');

        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DOT, Code.DASH, Code.DOT, Code.DASH, Code.DOT, Code.DASH}), '.');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DASH, Code.DOT, Code.DOT, Code.DASH, Code.DASH}), ',');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DOT, Code.DOT, Code.DASH, Code.DASH, Code.DOT, Code.DOT}), '?');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DOT, Code.DASH, Code.DASH, Code.DASH, Code.DASH, Code.DOT}), '\'');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DASH, Code.DOT, Code.DASH, Code.DASH}), '!');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DOT, Code.DASH, Code.DOT}), '/');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DASH, Code.DASH, Code.DOT}), '(');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DASH, Code.DASH, Code.DOT, Code.DASH}), ')');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DOT, Code.DASH, Code.DOT, Code.DOT, Code.DOT}), '&');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DASH, Code.DASH, Code.DOT, Code.DOT, Code.DOT}), ':');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DASH, Code.DOT, Code.DASH, Code.DOT}), ':');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DOT, Code.DOT, Code.DASH}), '=');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DOT, Code.DASH, Code.DOT, Code.DASH, Code.DOT}), '+');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DASH, Code.DOT, Code.DOT, Code.DOT, Code.DOT, Code.DASH}), '-');
        translationTableRussian.put(Arrays.hashCode(new Code[] { Code.DOT, Code.DOT, Code.DASH, Code.DASH, Code.DOT, Code.DASH}), '_');
        translationTableRussian.put(Arrays.hashCode(new Code[] {Code.DOT, Code.DASH, Code.DASH, Code.DOT, Code.DASH, Code.DOT}), '@');
    }

	/**
	 * Converts a string of Morse code (periods and dashes ) into a Character.
	 * @param codes a String of periods (.) and dashes (-).
	 * @return the character corresponding to the given Morse code.
	 */
	public static Character characterFromCode(String codes, boolean isUpperCase) {
		ArrayList<Code> codeArray = new ArrayList<Code>();
		for(char ch : codes.toCharArray()) {
			Code code = (ch == DOT_CHAR) ? Code.DOT : Code.DASH;
			codeArray.add(code);
		}
		
		return characterFromCode(codeArray, isUpperCase);
	}
	
	/**
	 * Converts an array of Codes into a Character.
	 * @param codes an array of Codes.
	 * @return the character corresponding to the given Morse code.
	 */
	public static Character characterFromCode(Code[] codes, boolean isUpperCase) {
        Character ch = getTranslationTable().get(Arrays.hashCode(codes));
        if (ch == null) {
            return null;
        }
        return isUpperCase ? ch.toString().toUpperCase().charAt(0) : ch.toString().toLowerCase().charAt(0);
	}
	
	/**
	 * Converts an ArrayList of Codes into a Character.
	 * @param codes an ArrayList of Codes.
	 * @return the character corresponding to the given Morse code.
	 */
	public static Character characterFromCode(ArrayList<Code> codes, boolean isUpperCase) {
		Code[] array = new Code[codes.size()];
		array = codes.toArray(array);
		return characterFromCode(array, isUpperCase);
	}

    private static SparseArray<Character> getTranslationTable() {
        switch (mCurrentLanguage) {
            case LANGUAGE_ENGLISH:
                return translationTableEnglish;
            case LANGUAGE_RUSSIAN:
                return translationTableRussian;
            default:
                throw new IllegalStateException("no current language specified");
        }
    }

    public static void setCurrentLanguage(Language language) {
        mCurrentLanguage = language;
    }

    public static Language getCurrentLanguage() {
        return mCurrentLanguage;
    }

    public static void toggleLanguage() {
        switch (mCurrentLanguage) {
            case LANGUAGE_ENGLISH:
                setCurrentLanguage(Language.LANGUAGE_RUSSIAN);
                break;
            case LANGUAGE_RUSSIAN:
                setCurrentLanguage(Language.LANGUAGE_ENGLISH);
                break;
            default:
                throw new IllegalStateException("no current language specified");
        }
    }
}
