function solve(n)
  num = math.floor(math.ceil(math.sqrt(n)) / 2);
  offset = (n - math.pow(2 * num - 1, 2)) % (2 * num);
  return num + math.abs(offset - num);
end

print(solve(1))
print(solve(12))
print(solve(23))
print(solve(1024))