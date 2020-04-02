{{RANGE}}
    upstream {{backend}} {
        {{policy}}
{{FOREACH_serverInsts}}        server   {{backendUrl}} {{max_fails}} {{fail_timeout}};
    }
{{END}}