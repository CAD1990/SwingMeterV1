import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public abstract class SwingModel implements SwingDynamics {

	public double calculateSwing(int lab, int con) {
		return 0.0;
	}

	/// Calculates +/- vote share as Int ///
	/**
	 * @param fifteen
	 *            - Party 2015 Vote share.
	 * @param seventeen
	 *            - Party 2017 Vote share.
	 * @return result - 2015 - 2017 Vote share
	 */
	public int voteIncrease(int fifteen, int seventeen) {
		Integer f = new Integer(fifteen);
		Integer s = new Integer(seventeen);
		Integer result = new Integer(s - f);
		return result;

	}

	/// Calculates Electorate ///
	/**
	 * @param turnout
	 *            - Takes turnout (%) as a double (e.g - 61.62)
	 * @param voterRoll
	 *            - Takes voter roll numbers as an int (e.g - 40000)
	 * @return voters - Returns the electorate as an int (e.g - 20000)
	 */
	public int calculateElectorate(double turnout, int voterRoll) {
		/// Convert Double to BigDecimal///
		BigDecimal conv = BigDecimal.valueOf(turnout);
		/// Division///
		BigDecimal fixed = conv.divide(new BigDecimal(100));
		/// Get Electoral Register ///
		int to = new Integer(voterRoll);
		/// Calculate Electorate ///
		BigDecimal ret = fixed.multiply(new BigDecimal(to));
		BigDecimal work = ret.setScale(0, RoundingMode.HALF_EVEN);
		/// Return Int ///
		Integer voters = work.intValueExact();
		return voters;
	}

	/// Generates formatted percentage ///
	/**
	 * @param base
	 *            - Takes percentage as a double
	 * @return percentage - Returns formatted percentages with (%) symbol
	 */
	public String getPercentString(double base) {
		/// Convert Double to BigDecimal///
		BigDecimal conv = BigDecimal.valueOf(base);
		/// Division///
		BigDecimal fixed = conv.divide(new BigDecimal(100));
		/// Formating Block///
		NumberFormat percentFormatter = NumberFormat.getPercentInstance();
		percentFormatter.setMinimumFractionDigits(0);
		/// Formatted String ///
		String percentage = new String(percentFormatter.format(fixed));
		return percentage;
	}

	public int voteShare2017(double party, int electorate) {
		/// Convert Double to BigDecimal///
		BigDecimal l = BigDecimal.valueOf(party);
		/// Division///
		BigDecimal fixl = l.divide(new BigDecimal(100));
		/// Electorate///
		Integer voters = new Integer(electorate);
		/// Vote Share Logic//
		BigDecimal lc = fixl.multiply(new BigDecimal(voters));
		/// Rounding ///
		BigDecimal round = lc.setScale(0, RoundingMode.HALF_EVEN);
		/// Passing Variables ///
		Integer value = new Integer(round.intValueExact());
		return value;
	}

	public double percentIncrease(int noVotes) {
		return 0.0;
	}

}
