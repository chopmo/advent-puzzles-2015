
# Part 1
houses = Hash.new(0); x = 0; y = 0; File.read("/Users/jtj/Downloads/houses.txt").each_char { |c| if c == '<'; x -= 1; elsif c == '>'; x += 1; elsif c == '^'; y -= 1; elsif c == 'v'; y += 1;  end; houses[ [x,y] ] += 1 }; houses.size

# Part 2
houses = Hash.new(0); x1 = x2 = y1 = y2 = 0; File.read("/Users/jtj/Downloads/houses.txt").each_char.to_a.in_groups_of(2).each { |c1, c2| if c1 == '<'; x1 -= 1; elsif c1 == '>'; x1 += 1; elsif c1 == '^'; y1 -= 1; elsif c1 == 'v'; y1 += 1;  end; if c2 == '<'; x2 -= 1; elsif c2 == '>'; x2 += 1; elsif c2 == '^'; y2 -= 1; elsif c2 == 'v'; y2 += 1;  end; houses[ [x1,y1] ] += 1; houses[ [x2,y2] ] += 1 }; houses.size
