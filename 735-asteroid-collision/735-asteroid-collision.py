class Solution:
    def asteroidCollision(self, asteroids):
        remain = []

        for v in asteroids:
            while len(remain) and remain[-1] > 0 and v < 0:
                if remain[-1] == -v:
                    remain.pop(); v = None;break
                elif remain[-1] < -v:
                    remain.pop()
                else: v=None;break
            if v: remain.append(v)
        return remain