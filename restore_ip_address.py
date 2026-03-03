class Solution:
    def restoreIpAddresses(self, s: str):
        def backtrack(start=0, path=[]):
            if len(path) == 4 and start == len(s):
                result.append(".".join(path))
                return
            if len(path) > 4:
                return

            for i in range(1, 4):
                if start + i > len(s):
                    break
                segment = s[start:start + i]
                if (segment[0] == '0' and len(segment) > 1) or int(segment) > 255:
                    continue
                backtrack(start + i, path + [segment])

        result = []
        backtrack()
        return result

# Example usage
solution = Solution()
result = solution.restoreIpAddresses("25525511135")
print(result)  # Output: ["255.255.11.135","255.255.111.35"]
