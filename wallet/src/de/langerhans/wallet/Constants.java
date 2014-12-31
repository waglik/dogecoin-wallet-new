/*
 * Copyright 2011-2014 the original author or authors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.langerhans.wallet;

import java.io.File;

import com.dogecoin.dogecoinj.core.NetworkParameters;
import com.dogecoin.dogecoinj.params.MainNetParams;
import com.dogecoin.dogecoinj.params.TestNet3Params;
import com.dogecoin.dogecoinj.utils.MonetaryFormat;

import android.os.Build;
import android.os.Environment;
import android.text.format.DateUtils;

/**
 * @author Andreas Schildbach
 */
public final class Constants
{
	public static final boolean TEST = R.class.getPackage().getName().contains("_test");

	/** Network this wallet is on (e.g. testnet or mainnet). */
	public static final NetworkParameters NETWORK_PARAMETERS = TEST ? TestNet3Params.get() : MainNetParams.get();

	public final static class Files
	{
		private static final String FILENAME_NETWORK_SUFFIX = NETWORK_PARAMETERS.getId().equals(NetworkParameters.ID_MAINNET) ? "" : "-testnet";

		/** Filename of the wallet. */
		public static final String WALLET_FILENAME_PROTOBUF = "wallet-protobuf" + FILENAME_NETWORK_SUFFIX;

		/** Filename of the automatic key backup (old format, can only be read). */
		public static final String WALLET_KEY_BACKUP_BASE58 = "key-backup-base58" + FILENAME_NETWORK_SUFFIX;

		/** Filename of the automatic wallet backup. */
		public static final String WALLET_KEY_BACKUP_PROTOBUF = "key-backup-protobuf" + FILENAME_NETWORK_SUFFIX;

		/** Manual backups go here. */
		public static final File EXTERNAL_WALLET_BACKUP_DIR = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

		/** Filename of the manual key backup (old format, can only be read). */
		public static final String EXTERNAL_WALLET_KEY_BACKUP = "dogecoin-wallet-keys" + FILENAME_NETWORK_SUFFIX;

		/** Filename of the manual wallet backup. */
		public static final String EXTERNAL_WALLET_BACKUP = "dogecoin-wallet-backup" + FILENAME_NETWORK_SUFFIX;

		/** Filename of the block store for storing the chain. */
		public static final String BLOCKCHAIN_FILENAME = "blockchain" + FILENAME_NETWORK_SUFFIX;

		/** Filename of the block checkpoints file. */
		public static final String CHECKPOINTS_FILENAME = "checkpoints" + FILENAME_NETWORK_SUFFIX + ".txt";
	}

	/** Maximum size of backups. Files larger will be rejected. */
	public static final long BACKUP_MAX_CHARS = 10000000;

	/** Base URL for browsing transactions, blocks or addresses. */
	public static final String EXPLORE_BASE_URL_TX_PROD = "https://chain.so/tx/DOGE/";
	public static final String EXPLORE_BASE_URL_TX_TEST = "https://chain.so/tx/DOGETEST/";
	public static final String EXPLORE_BASE_URL_ADDR_PROD = "https://chain.so/address/DOGE/";
	public static final String EXPLORE_BASE_URL_ADDR_TEST = "https://chain.so/address/DOGETEST/";
	public static final String EXPLORE_BASE_URL_BLOCK_PROD = "https://chain.so/block/DOGE/";
	public static final String EXPLORE_BASE_URL_BLOCK_TEST = "https://chain.so/block/DOGETEST/";
	public static final String EXPLORE_BASE_URL_TX = NETWORK_PARAMETERS.getId().equals(NetworkParameters.ID_MAINNET) ? EXPLORE_BASE_URL_TX_PROD
			: EXPLORE_BASE_URL_TX_TEST;
	public static final String EXPLORE_BASE_URL_ADDR = NETWORK_PARAMETERS.getId().equals(NetworkParameters.ID_MAINNET) ? EXPLORE_BASE_URL_ADDR_PROD
			: EXPLORE_BASE_URL_ADDR_TEST;
	public static final String EXPLORE_BASE_URL_BLOCK = NETWORK_PARAMETERS.getId().equals(NetworkParameters.ID_MAINNET) ? EXPLORE_BASE_URL_BLOCK_PROD
			: EXPLORE_BASE_URL_BLOCK_TEST;

	private static final String BITEASY_API_URL_PROD = "https://api.biteasy.com/blockchain/v1/";
	private static final String BITEASY_API_URL_TEST = "https://api.biteasy.com/testnet/v1/";
	/** Base URL for blockchain API. */
	public static final String BITEASY_API_URL = NETWORK_PARAMETERS.getId().equals(NetworkParameters.ID_MAINNET) ? BITEASY_API_URL_PROD
			: BITEASY_API_URL_TEST;

	/** URL to fetch version alerts from. */
	public static final String VERSION_URL = "http://parasprite.net:8081/version";

	/** MIME type used for transmitting single transactions. */
	public static final String MIMETYPE_TRANSACTION = "application/x-dogetx";

	/** MIME type used for transmitting wallet backups. */
	public static final String MIMETYPE_WALLET_BACKUP = "application/x-dogecoin-wallet-backup";

	/** Number of confirmations until a transaction is fully confirmed. */
	public static final int MAX_NUM_CONFIRMATIONS = 3;

	/** User-agent to use for network access. */
	public static final String USER_AGENT = "Dogecoin Wallet";

	/** Default currency to use if all default mechanisms fail. */
	public static final String DEFAULT_EXCHANGE_CURRENCY = "USD";

	/** Donation address for tip/donate action. */
	public static final String DONATION_ADDRESS = "DHRPHr7JweEwzSP2b239vZh1LQwe7kggSq";

	/** Recipient e-mail address for reports. */
	public static final String REPORT_EMAIL = "dogecoinandroid@gmail.com";

	/** Subject line for manually reported issues. */
	public static final String REPORT_SUBJECT_ISSUE = "Reported issue";

	/** Subject line for crash reports. */
	public static final String REPORT_SUBJECT_CRASH = "Crash report";

	public static final char CHAR_HAIR_SPACE = '\u200a';
	public static final char CHAR_THIN_SPACE = '\u2009';
	public static final char CHAR_ALMOST_EQUAL_TO = '\u2248';
	public static final char CHAR_CHECKMARK = '\u2713';
	public static final char CURRENCY_PLUS_SIGN = '\uff0b';
	public static final char CURRENCY_MINUS_SIGN = '\uff0d';
	public static final String PREFIX_ALMOST_EQUAL_TO = Character.toString(CHAR_ALMOST_EQUAL_TO) + CHAR_THIN_SPACE;
	public static final int ADDRESS_FORMAT_GROUP_SIZE = 4;
	public static final int ADDRESS_FORMAT_LINE_SIZE = 12;

	public static final MonetaryFormat LOCAL_FORMAT = new MonetaryFormat().noCode().minDecimals(4).optionalDecimals();

	public static final String SOURCE_URL = "https://github.com/langerhans/dogecoin-wallet-new";
	public static final String BINARY_URL = "http://langerhans.github.io/dogecoin-wallet-new/releases";
	public static final String MARKET_APP_URL = "market://details?id=%s";
	public static final String WEBMARKET_APP_URL = "https://play.google.com/store/apps/details?id=%s";

	public static final int HTTP_TIMEOUT_MS = 15 * (int) DateUtils.SECOND_IN_MILLIS;
	public static final int PEER_TIMEOUT_MS = 15 * (int) DateUtils.SECOND_IN_MILLIS;

	public static final long LAST_USAGE_THRESHOLD_JUST_MS = DateUtils.HOUR_IN_MILLIS;
	public static final long LAST_USAGE_THRESHOLD_RECENTLY_MS = 2 * DateUtils.DAY_IN_MILLIS;

	public static final int SDK_JELLY_BEAN = 16;
	public static final int SDK_JELLY_BEAN_MR2 = 18;

	public static final int SDK_DEPRECATED_BELOW = Build.VERSION_CODES.ICE_CREAM_SANDWICH;

	public static final boolean BUG_OPENSSL_HEARTBLEED = Build.VERSION.SDK_INT == Constants.SDK_JELLY_BEAN
			&& Build.VERSION.RELEASE.startsWith("4.1.1");

	public static final int MEMORY_CLASS_LOWEND = 48;
}