

package com.dmsl.anyplace.googleapi;

import java.io.Serializable;

import com.dmsl.anyplace.nav.IPoisClass;
import com.google.api.client.util.Key;

public class Place implements Serializable, IPoisClass {

	@Key
	public String id;

	@Key
	public String name;

	@Key
	public String reference;

	@Key
	public String icon;

	@Key
	public String vicinity;

	@Key
	public Geometry geometry;

	@Key
	public String formatted_address = "";

	@Key
	public String formatted_phone_number;

	@Override
	public String toString() {
		return name + " - " + id + " - " + reference;
	}

	public static class Geometry implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6671182645807819149L;
		@Key
		public Location location;
	}

	public static class Location implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 177304297858841489L;

		@Key
		public double lat;

		@Key
		public double lng;
	}

	@Override
	public double lat() {
		return geometry.location.lat;
	}

	@Override
	public double lng() {
		return geometry.location.lng;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String description() {
		return formatted_address;
	}

	@Override
	public Type type() {
		return Type.GooglePlace;
	}

	@Override
	public String id() {
		// maybe we should return reference
		return id;
	}
}