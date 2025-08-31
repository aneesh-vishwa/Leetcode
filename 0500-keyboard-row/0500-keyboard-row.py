class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        # word = words.lower()
        line_1 = {'q','w','e','r','t','y','u','i','o','p'}
        line_2 = {'a','s','d','f','g','h','j','k','l'}
        line_3 = {'z','x','c','v','b','n','m'}
        
        result = []
        for word in words:
            word_lower = word.lower()
            in_line_1 = all(char in line_1 for char in word_lower)
            in_line_2 = all(char in line_2 for char in word_lower)
            in_line_3 = all(char in line_3 for char in word_lower)
            if in_line_1 or in_line_2 or in_line_3:
                result.append(word)
        return result