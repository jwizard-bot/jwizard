/*
 * Copyright (c) 2024 by JWizard
 * Originally developed by Miłosz Gilga <https://miloszgilga.pl>
 */
package pl.jwizard.jwc.core.property

import kotlin.reflect.KClass

/**
 * Enum class representing configuration properties. This serves as a single source of truth for property keys and
 * their types.
 *
 * @property key The key used to retrieve the property value from various property sources.
 * @property type The type of the property value. Defaults to [String] if not specified.
 * @constructor Creates a [BotProperty] with the specified [key] and [type]. If only [key] is provided,
 * 							the [type] defaults to [String].
 * @author Miłosz Gilga
 * @see BotMultiProperty
 */
enum class BotProperty(
	val key: String,
	val type: KClass<*> = String::class,
) {

	/**
	 * Determinate, if application at start should load environment variables from .env file.
	 */
	ENV_ENABLED("env.enabled", Boolean::class),

	/**
	 * Deployment build version. Generated by CI/CD pipeline. Default value: *UNKNOWN*.
	 */
	DEPLOYMENT_BUILD_VERSION("deployment.build-version"),

	/**
	 * Deployment last build date. Generated by CI/CD pipeline. Default value: *UNKNOWN*.
	 */
	DEPLOYMENT_LAST_BUILD_DATE("deployment.last-build-date"),

	/**
	 * Database JDBC url provider.
	 */
	DB_URL("db.jdbc"),

	/**
	 * Database username.
	 */
	DB_USERNAME("db.username"),

	/**
	 * Database password.
	 */
	DB_PASSWORD("db.password"),

	/**
	 * Vault key storage url.
	 */
	VAULT_URL("vault.url"),

	/**
	 * Vault key storage access token.
	 */
	VAULT_TOKEN("vault.token"),

	/**
	 * Vault key storage KV backend name.
	 */
	VAULT_KV_BACKEND("vault.kv.backend"),

	/**
	 * Vault key storage KV default context. Load default secrets independently of application name.
	 */
	VAULT_KV_DEFAULT_CONTEXT("vault.kv.default-context"),

	/**
	 * Vault key storage KV application name. Load all secrets from this pre-path.
	 */
	VAULT_KV_APPLICATION_NAME("vault.kv.application-name"),

	/**
	 * JDA instance name.
	 */
	JDA_NAME("jda.name"),

	/**
	 * JDA instance icon path.
	 */
	JDA_ICON_PATH("jda.icon-path"),

	/**
	 * JDA secret token.
	 */
	JDA_SECRET_TOKEN("jda.secret-token"),

	/**
	 * JDA default activity. Enabled when [JDA_SPLASHES_ENABLED] property is set to false.
	 */
	JDA_DEFAULT_ACTIVITY("jda.default-activity"),

	/**
	 * Max elements per page number for JDA pagination generator.
	 */
	JDA_PAGINATION_MAX_ELEMENTS_PER_PAGE("jda.pagination.max-elements-per-page", Int::class),

	/**
	 * JDA pagination generator menu visibility in seconds.
	 */
	JDA_PAGINATION_MENU_ALIVE("jda.pagination.menu-alive-sec", Int::class),

	/**
	 * JDA splashes toggle boolean property. If true, splashes are enabled, otherwise show nothing.
	 */
	JDA_SPLASHES_ENABLED("jda.splashes.enabled", Boolean::class),

	/**
	 * JDA splashes interval in seconds.
	 */
	JDA_SPLASHES_INTERVAL("jda.splashes.interval-sec", Long::class),

	/**
	 * JWizard API service host url.
	 */
	SERVICE_API_URL("service.api-url"),

	/**
	 * JWizard Content Delivery Network service host url.
	 */
	SERVICE_CDN_URL("service.cdn-url"),

	/**
	 * I18n default language (as language tag, without localization property).
	 */
	I18N_DEFAULT_LANGUAGE("i18n.default-language"),
	;
}
