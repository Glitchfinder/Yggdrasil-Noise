/*
 * Copyright (c) 2016 Sean Porter <glitchkey@gmail.com>
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
 
 package com.glitchkey.yggdrasil.noise;

//* IMPORTS: JDK/JRE
	//* NOT NEEDED
//* IMPORTS: SPONGE
	//* NOT NEEDED
//* IMPORTS: YGGDRASIL
	//* NOT NEEDED
//* IMPORTS: OTHER
	//* NOT NEEDED

public abstract class NoiseGenerator
{
	public static double noise(long seed, double x)
	{
		return noise(seed, x, 0, 0, 6, 1D, 2D);
	}

	public static double noise(long seed, double x, double y)
	{
		return noise(seed, x, y, 0, 6, 1D, 2D);
	}

	public static double noise(long seed, double x, double y, double z)
	{
		return noise(seed, x, y, z, 6, 1D, 2D);
	}

	public static double noise(long seed, double x, int octaves,
		double frequency, double amplitude)
	{
		return noise(seed, x, 0, 0, octaves, frequency, amplitude);
	}

	public static double noise(long seed, double x, double y, int octaves,
		double frequency, double amplitude)
	{
		return noise(seed, x, y, 0, octaves, frequency, amplitude);
	}

	public static double noise(long seed, double x, double y, double z,
		int octaves, double frequency, double amplitude)
	{
		String msg = "Custom noise is being requested of the : ";
		msg += "NoiseGenerator class. Please cast to an appropriate ";
		nsg += "noise type before trying to get data."
		throw new UnsupportedOperationException(msg);
	}

	protected static double force32BitRange(double n)
	{
		if (n >= 1073741824D)
			return (2D * n % 1073741824D) - 1073741824D;
		else if (n <= -1073741824D)
			return (2D * n % 1073741824D) + 1073741824D;
		else
			return n;
	}

	protected static double lerp(double x, double y, double z)
	{
		return (1D - z) * x + (z * y);
	}

	protected static double curve(double val)
	{
		return (val * val * (3.0 - 2.0 * val));
	}
}
