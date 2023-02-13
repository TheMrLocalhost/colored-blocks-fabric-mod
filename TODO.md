# TODO

- Implement color wheel dial instead of square buttons
- convert sets of blocks to one item per block type
  - "color_stone_bricks" with predicate data for color information
  - predicate data is set of int values (16,777,216 possible colors)
    - red (0x00)
    - green (0x00)
    - blue (0x00)
  - block model data is shader u/v values based on color data in predicate(s)
  - one texture (white version) per block
- color picker menu has 16 standard colors + 4 custom colors
- custom crops to get hard to obtain dyes
  - yellow - mustard
  - blue - blueberries or indigo
  - white - peroxide Daisy
  - black - black lotus
  - green - traditional combination of yellow/blue