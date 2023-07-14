package com.example.pokedex_android.util

import android.view.View
import com.example.pokedex_android.R

fun View.setTypeColor(type: String) {
    when (type) {
        IndexType.GRASS.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.grass_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.BUG.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.bug_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.DARK.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.dark_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.DRAGON.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.dragon_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.ELECTRIC.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.electric_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.FAIRY.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.fairy_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.FIGHTING.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.fighting_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.FIRE.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.fire_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.NORMAL.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.normal_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.WATER.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.water_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.GHOST.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.ghost_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.ICE.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.ice_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.PSYCHIC.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.psychic_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.ROCK.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.rock_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.STEEL.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.steel_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.FLYING.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.flying_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.GROUND.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.ground_light_color,
                    resources.newTheme()
                )
            )
        }

        IndexType.POISON.type -> {
            this.setBackgroundColor(
                resources.getColor(
                    R.color.poison_light_color,
                    resources.newTheme()
                )
            )
        }
    }
}

fun setTypeBackground(type: String): Int {
    when (type) {
        IndexType.GRASS.type -> {
            return R.color.grass_light_color
        }

        IndexType.BUG.type -> {
            return R.color.bug_light_color
        }

        IndexType.DARK.type -> {
            return R.color.dark_light_color
        }

        IndexType.DRAGON.type -> {
            return R.color.dragon_light_color
        }

        IndexType.ELECTRIC.type -> {
            return R.color.electric_light_color
        }

        IndexType.FAIRY.type -> {
            return R.color.fairy_light_color
        }

        IndexType.FIGHTING.type -> {
            return R.color.fighting_light_color
        }

        IndexType.FIRE.type -> {
            return R.color.fire_light_color
        }

        IndexType.NORMAL.type -> {
            return R.color.normal_light_color
        }

        IndexType.WATER.type -> {
            return R.color.water_light_color
        }

        IndexType.GHOST.type -> {
            return R.color.ghost_light_color
        }

        IndexType.ICE.type -> {
            return R.color.ice_light_color
        }

        IndexType.PSYCHIC.type -> {
            return R.color.psychic_light_color
        }

        IndexType.ROCK.type -> {
            return R.color.rock_light_color
        }

        IndexType.STEEL.type -> {
            return R.color.steel_light_color
        }

        IndexType.FLYING.type -> {
            return R.color.flying_light_color
        }

        IndexType.GROUND.type -> {
            return R.color.ground_light_color
        }

        IndexType.POISON.type -> {
            return R.color.poison_light_color
        }

        else -> {
            return R.color.normal_light_color
        }
    }
}


fun setTypeBackgroundDarker(type: String): Int {
    when (type) {
        IndexType.GRASS.type -> {
            return R.color.grass_color
        }

        IndexType.BUG.type -> {
            return R.color.bug_color
        }

        IndexType.DARK.type -> {
            return R.color.dark_color
        }

        IndexType.DRAGON.type -> {
            return R.color.dragon_color
        }

        IndexType.ELECTRIC.type -> {
            return R.color.electric_color
        }

        IndexType.FAIRY.type -> {
            return R.color.fairy_color
        }

        IndexType.FIGHTING.type -> {
            return R.color.fighting_color
        }

        IndexType.FIRE.type -> {
            return R.color.fire_color
        }

        IndexType.NORMAL.type -> {
            return R.color.normal_color
        }

        IndexType.WATER.type -> {
            return R.color.water_color
        }

        IndexType.GHOST.type -> {
            return R.color.ghost_color
        }

        IndexType.ICE.type -> {
            return R.color.ice_color
        }

        IndexType.PSYCHIC.type -> {
            return R.color.psychic_color
        }

        IndexType.ROCK.type -> {
            return R.color.rock_color
        }

        IndexType.STEEL.type -> {
            return R.color.steel_color
        }

        IndexType.FLYING.type -> {
            return R.color.flying_color
        }

        IndexType.GROUND.type -> {
            return R.color.ground_color
        }

        IndexType.POISON.type -> {
            return R.color.poison_color
        }

        else -> {
            return R.color.normal_color
        }
    }
}