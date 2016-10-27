procedure IDDFS(root)
    for depth from 0 to ∞
        found ← DLS(root, depth)
        if found ≠ null
            return found

procedure DLS(node, depth)
    if depth = 0 and node is a goal
        return node
    if depth > 0
        foreach child of node
            found ← DLS(child, depth−1)
            if found ≠ null
                return found
    return null
