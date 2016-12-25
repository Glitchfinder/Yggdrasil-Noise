/*
 * Copyright (c) 2016 Sean Porter <glitchkey@gmail.com>
 *
 * Original implementation of Ridged Multifractal by F. Kenton Musgrave, 1994
 * Adapted from an implementation found in jlibnoise, by Garret Fleenor
 * Original libnoise implementation by Jason Bevins
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

public class RidgedMultifractal extends Perlin
{
	protected static double[] spectralWeights;

	public static void CalculateSpectralWeights()
	{
		double h = 1D;
		double frequency = 1D;
		spectralWeights = new double[30];

		for (int i = 0; i < 30; i++) {
			spectralWeights[i] = Math.pow(frequency, -h);
			frequency *= 2D;
		}
	}

	public static double noise(long seed, double x, double y, double z,
		int octaves, double frequency, double amplitude)
	{
		double cx = x * frequency;
		double cy = y * frequency;
		double cz = z * frequency;
		
		double signal;
		double value  = 0D;
		double weight = 1D;
		double offset = 1D;
		double gain   = 2D;

		octaves = Math.min(octaves, 30);

		for (int octave = 0; octave < octaves; octave++) {
			double nx, ny, nz;

			nx = force32BitRange(cx);
			ny = force32BitRange(cy);
			nz = force32BitRange(cz);

			int cSeed = (((int) seed) + octave) & 0x7fffffff;
			signal = gradientCoherentNoise(nx, ny, nz, cSeed);

			signal = Math.abs(signal);
			signal = offset - signal;
			signal *= signal;
			signal *= weight;
			weight = signal * gain;

			if (weight > 1D)
				weight = 1D;
			if (weight < 0D)
				weight = 0D;

			value += signal * spectralWeights[octave];

			cx *= amplitude;
			cy *= amplitude;
			cz *= amplitude;
		}

		return (value) - 1.0;
	}
}