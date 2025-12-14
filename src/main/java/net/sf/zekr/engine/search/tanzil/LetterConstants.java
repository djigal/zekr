/*
 *               In the name of Allah
 * This file is part of The Zekr Project. Use is subject to
 * license terms.
 *
 * Author:         Hamid Zarrabi-Zadeh, Mohsen Saboorian
 * Start Date:     Mar 17, 2008
 */
package net.sf.zekr.engine.search.tanzil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Helper class for Regex-based search.
 * 
 * @author Hamid Zarrabi-Zadeh
 * @author Mohsen Saboorian
 */
public class LetterConstants {
	public static Map<String, Character> CHARS = new LinkedHashMap<String, Character>();
	static {
		// letters used in Quran text
		CHARS.put("HAMZA", Character.valueOf('\u0621'));
		CHARS.put("ALEF_WITH_MADDA_ABOVE", Character.valueOf('\u0622'));
		CHARS.put("ALEF_WITH_HAMZA_ABOVE", Character.valueOf('\u0623'));
		CHARS.put("WAW_WITH_HAMZA_ABOVE", Character.valueOf('\u0624'));
		CHARS.put("ALEF_WITH_HAMZA_BELOW", Character.valueOf('\u0625'));
		CHARS.put("YEH_WITH_HAMZA", Character.valueOf('\u0626'));
		CHARS.put("ALEF", Character.valueOf('\u0627'));
		CHARS.put("BEH", Character.valueOf('\u0628'));
		CHARS.put("MARBUTA", Character.valueOf('\u0629'));
		CHARS.put("TEH", Character.valueOf('\u062A'));
		CHARS.put("THEH", Character.valueOf('\u062B'));
		CHARS.put("JEMM", Character.valueOf('\u062C'));
		CHARS.put("HAH", Character.valueOf('\u062D'));
		CHARS.put("KHAH", Character.valueOf('\u062E'));
		CHARS.put("DAL", Character.valueOf('\u062F'));
		CHARS.put("THAL", Character.valueOf('\u0630'));
		CHARS.put("REH", Character.valueOf('\u0631'));
		CHARS.put("ZAIN", Character.valueOf('\u0632'));
		CHARS.put("SEEN", Character.valueOf('\u0633'));
		CHARS.put("SHEEN", Character.valueOf('\u0634'));
		CHARS.put("SAD", Character.valueOf('\u0635'));
		CHARS.put("DAD", Character.valueOf('\u0636'));
		CHARS.put("TAH", Character.valueOf('\u0637'));
		CHARS.put("ZAH", Character.valueOf('\u0638'));
		CHARS.put("AIN", Character.valueOf('\u0639'));
		CHARS.put("GHAIN", Character.valueOf('\u063A'));
		CHARS.put("TATWEEL", Character.valueOf('\u0640'));
		CHARS.put("FEH", Character.valueOf('\u0641'));
		CHARS.put("QAF", Character.valueOf('\u0642'));
		CHARS.put("KAF", Character.valueOf('\u0643'));
		CHARS.put("LAM", Character.valueOf('\u0644'));
		CHARS.put("MEEM", Character.valueOf('\u0645'));
		CHARS.put("NOON", Character.valueOf('\u0646'));
		CHARS.put("HEH", Character.valueOf('\u0647'));
		CHARS.put("WAW", Character.valueOf('\u0648'));
		CHARS.put("ALEF_MAKSURA", Character.valueOf('\u0649'));
		CHARS.put("YEH", Character.valueOf('\u064A'));
		CHARS.put("FATHATAN", Character.valueOf('\u064B'));
		CHARS.put("DAMMATAN", Character.valueOf('\u064C'));
		CHARS.put("KASRATAN", Character.valueOf('\u064D'));
		CHARS.put("FATHA", Character.valueOf('\u064E'));
		CHARS.put("DAMMA", Character.valueOf('\u064F'));
		CHARS.put("KASRA", Character.valueOf('\u0650'));
		CHARS.put("SHADDA", Character.valueOf('\u0651'));
		CHARS.put("SUKUN", Character.valueOf('\u0652'));
		CHARS.put("MADDA", Character.valueOf('\u0653'));
		CHARS.put("HAMZA_ABOVE", Character.valueOf('\u0654'));
		CHARS.put("HAMZA_BELOW", Character.valueOf('\u0655'));
		CHARS.put("SMALL_ALEF", Character.valueOf('\u065F'));
		CHARS.put("SUPERSCRIPT_ALEF", Character.valueOf('\u0670'));
		CHARS.put("ALEF_WASLA", Character.valueOf('\u0671'));
		CHARS.put("HIGH_SALA", Character.valueOf('\u06D6'));
		CHARS.put("HIGH_GHALA", Character.valueOf('\u06D7'));
		CHARS.put("HIGH_MEEM_INITIAL_FORM", Character.valueOf('\u06D8'));
		CHARS.put("HIGH_LA", Character.valueOf('\u06D9'));
		CHARS.put("HIGH_JEMM", Character.valueOf('\u06DA'));
		CHARS.put("HIGH_THREE_DOT", Character.valueOf('\u06DB'));
		CHARS.put("HIGH_SEEN", Character.valueOf('\u06DC'));
		CHARS.put("RUB_EL_HIZB", Character.valueOf('\u06DE'));
		CHARS.put("HIGH_ROUNDED_ZERO", Character.valueOf('\u06DF'));
		CHARS.put("HIGH_UPRIGHT_ZERO", Character.valueOf('\u06E0'));
		CHARS.put("HIGH_MEEM", Character.valueOf('\u06E2'));
		CHARS.put("LOW_SEEN", Character.valueOf('\u06E3'));
		CHARS.put("SMALL_WAW", Character.valueOf('\u06E5'));
		CHARS.put("SMALL_YEH", Character.valueOf('\u06E6'));
		CHARS.put("HIGH_NOON", Character.valueOf('\u06E8'));
		CHARS.put("SAJDAH", Character.valueOf('\u06E9'));
		CHARS.put("LOW_STOP", Character.valueOf('\u06EA'));
		CHARS.put("HIGH_STOP", Character.valueOf('\u06EB'));
		CHARS.put("HIGH_STOP_FILLED", Character.valueOf('\u06EC'));
		CHARS.put("LOW_MEEM", Character.valueOf('\u06ED'));
		CHARS.put("HAMZA_ABOVE_ALEF", Character.valueOf('\u0675'));
		CHARS.put("DOTLESS_BEH", Character.valueOf('\u066E'));
		CHARS.put("HIGH_YEH", Character.valueOf('\u06E7'));
		CHARS.put("ZWNJ", Character.valueOf('\u200C'));
		CHARS.put("NBSP", Character.valueOf('\u00A0'));
		CHARS.put("NNBSP", Character.valueOf('\u202F'));

		// other letters
		CHARS.put("ARABIC_COMMA", Character.valueOf('\u060C'));
		CHARS.put("ARABIC_SEMICOLON", Character.valueOf('\u061B'));
		
		CHARS.put("FARSI_YEH", Character.valueOf('\u06CC'));
		CHARS.put("FARSI_HIGH_HAMZA", Character.valueOf('\u0674'));
		CHARS.put("FARSI_KEHEH", Character.valueOf('\u06A9'));
		CHARS.put("SWASH_KAF", Character.valueOf('\u06AA'));
		CHARS.put("YEH_BARREE", Character.valueOf('\u06D2'));
	}

	// letter groups
	public static Map<String, String> GROUPS = new LinkedHashMap<String, String>();
	static {
		GROUPS.put("LETTER", "[$HAMZA-$YEH]");
		GROUPS.put("HARAKA", "[$FATHATAN-$MADDA$SUPERSCRIPT_ALEF]");
		GROUPS.put("SPACE", "[\\\\s$HIGH_SALA-$LOW_MEEM]*\\\\s");
		GROUPS.put("HAMZA_SHAPE", "[$HAMZA_ABOVE$HAMZA$ALEF_WITH_HAMZA_ABOVE-$YEH_WITH_HAMZA]");
		GROUPS.put("LETTER_HARAKA", "[$HAMZA-$ALEF_WASLA]");
	}
}
