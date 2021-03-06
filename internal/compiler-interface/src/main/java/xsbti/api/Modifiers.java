/*
 * Zinc - The incremental compiler for Scala.
 * Copyright 2011 - 2017, Lightbend, Inc.
 * Copyright 2008 - 2010, Mark Harrah
 * This software is released under the terms written in LICENSE.
 */

package xsbti.api;

public final class Modifiers implements java.io.Serializable
{
	private static final int AbstractBit = 0;
	private static final int OverrideBit = 1;
	private static final int FinalBit = 2;
	private static final int SealedBit = 3;
	private static final int ImplicitBit = 4;
	private static final int LazyBit = 5;
	private static final int MacroBit = 6;
	private static final int SuperAccessorBit = 7;

	private static int flag(boolean set, int bit)
	{
		return set ? (1 << bit) : 0;
	}

	public Modifiers(boolean isAbstract, boolean isOverride, boolean isFinal, boolean isSealed, boolean isImplicit, boolean isLazy, boolean isMacro, boolean isSuperAccessor)
	{
		this.flags = (byte)(
			flag(isAbstract, AbstractBit) |
			flag(isOverride, OverrideBit) |
			flag(isFinal, FinalBit) |
			flag(isSealed, SealedBit) |
			flag(isImplicit, ImplicitBit) |
			flag(isLazy, LazyBit) |
			flag(isMacro, MacroBit) |
			flag(isSuperAccessor, SuperAccessorBit)
		);
	}

	private final byte flags;

	private boolean flag(int bit)
	{
		return (flags & (1 << bit)) != 0;
	}

	public final byte raw()
	{
		return flags;
	}

	public final boolean isAbstract()
	{
		return flag(AbstractBit);
	}
	public final boolean isOverride()
	{
		return flag(OverrideBit);
	}
	public final boolean isFinal()
	{
		return flag(FinalBit);
	}
	public final boolean isSealed()
	{
		return flag(SealedBit);
	}
	public final boolean isImplicit()
	{
		return flag(ImplicitBit);
	}
	public final boolean isLazy()
	{
		return flag(LazyBit);
	}
	public final boolean isMacro()
	{
		return flag(MacroBit);
	}
	public final boolean isSuperAccessor()
	{
		return flag(SuperAccessorBit);
	}
	public boolean equals(Object o)
	{
		return (o instanceof Modifiers) && flags == ((Modifiers)o).flags;
	}
	public int hashCode()
	{
		return flags;
	}
	public String toString()
	{
		return "Modifiers(" + "isAbstract: " + isAbstract() + ", " + "isOverride: " + isOverride() + ", " + "isFinal: " + isFinal() + ", " + "isSealed: " + isSealed() + ", " + "isImplicit: " + isImplicit() + ", " + "isLazy: " + isLazy() + ", " + "isMacro: " + isMacro()+ ", isSuperAccessor:" + isSuperAccessor() + ")";
	}
}
