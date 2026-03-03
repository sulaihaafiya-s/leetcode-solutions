class Solution:
    def wordBreak(self, s: str, wordDict: list) -> list:
        wordSet = set(wordDict)
        memo = {}

        def backtrack(start):
            if start in memo:
                return memo[start]
            if start == len(s):
                return [""]

            sentences = []
            for end in range(start + 1, len(s) + 1):
                word = s[start:end]
                if word in wordSet:
                    for sub_sentence in backtrack(end):
                        if sub_sentence:
                            sentences.append(word + " " + sub_sentence)
                        else:
                            sentences.append(word)
            
            memo[start] = sentences
            return sentences
            
        return backtrack(0)

# Example usage
solution = Solution()
result1 = solution.wordBreak("catsanddog", ["cat", "cats", "and", "sand", "dog"])
result2 = solution.wordBreak("pineapplepenapple", ["apple", "pen", "applepen", "pine", "pineapple"])
print(result1)  # Output: ["cats and dog", "cat sand dog"]
print(result2)  # Output: ["pine apple pen apple", "pineapple pen apple", "pine applepen apple"]
