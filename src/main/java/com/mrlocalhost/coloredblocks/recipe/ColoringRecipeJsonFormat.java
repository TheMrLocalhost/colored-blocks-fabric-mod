package com.mrlocalhost.coloredblocks.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/*
{
    "pattern": [
        "###",
        "#@#",
        "###"
    ],
    "key": {
        "blockToColor" : {
            "tag": "colored_blocks:colorable_stone_bricks"
        },
        "dye": {
            "item": "minecraft:red_dye"
        }
    },
    "result": {
        "output": "colored_blocks:colored_stone_bricks",
        "amount": "8",
        "nbtRed": "A",
        "nbtGreen": "0",
        "nbtBlue": "2"
    }
}
*/
public class ColoringRecipeJsonFormat {
    JsonArray pattern;
    JsonObject key;
    JsonObject result;
}
