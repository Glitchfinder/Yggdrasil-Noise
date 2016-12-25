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

package com.glitchkey.yggdrasil;

//* IMPORTS: JDK/JRE
	//* NOT NEEDED
//* IMPORTS: SPONGE
import org.spongepowered.api.plugin.Plugin;
//* IMPORTS: YGGDRASIL
import com.glitchkey.yggdrasil.noise.RidgedMultifractal;
//* IMPORTS: OTHER
	//* NOT NEEDED

@Plugin(id = PomData_Noise.ARTIFACT_ID, name = PomData_Noise.NAME,
	version = PomData_Noise.VERSION)

public class YggdrasilNoise
{
	public YggdrasilNoise() {
		RidgedMultifractal.CalculateSpectralWeights();
	}
}
